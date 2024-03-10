package com.example.furniture.demo.service.impl;

import com.example.furniture.demo.dto.HoleDTO;
import com.example.furniture.demo.entity.Hole;
import com.example.furniture.demo.mapper.HoleMapper;
import com.example.furniture.demo.repository.HoleRepository;
import com.example.furniture.demo.service.FurnitureDetailService;
import com.example.furniture.demo.service.HoleService;
import com.example.furniture.demo.service.PatternService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HoleServiceImpl implements HoleService {

    private final HoleRepository holeRepository;
    private final PatternService patternService;
    private final FurnitureDetailService furnitureDetailService;
    private final HoleMapper holeMapper;

    @Override
    public List<HoleDTO> getAllHoles() {
        return holeRepository.findAll().stream().map(hole -> holeMapper.fromEntity(hole)).toList();
    }

    @Override
    public HoleDTO getHole(Long id) {
        return holeMapper
                .fromEntity(
                        holeRepository.findById(id)
                                .orElseThrow(()->new NoSuchElementException("There is not hole with id"+id)));
    }

    @Override
    @Transactional
    public void createHole(HoleDTO holeDTO) {
        holeRepository.save(holeMapper.toEntity(holeDTO));
    }

    @Override
    @Transactional
    public void createWithPattern(HoleDTO holeDTO, String code) {
        holeRepository.save(
                holeMapper.toEntity(
                        patternService.calculateHoleByPattern(
                                furnitureDetailService.getFurnitureById(
                                        holeDTO.getFurnitureDetail().getId()), holeDTO, code)));
    }

    @Override
    @Transactional
    public void updateHole(HoleDTO holeDTO) {
        getHole(holeDTO.getId());
        // call this method because if hole with this id not found, we will get exception btw
        holeRepository.save(holeMapper.toEntity(holeDTO));
    }
}
