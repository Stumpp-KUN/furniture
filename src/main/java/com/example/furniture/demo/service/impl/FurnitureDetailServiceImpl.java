package com.example.furniture.demo.service.impl;

import com.example.furniture.demo.dto.FurnitureDTO;
import com.example.furniture.demo.mapper.FurnitureMapper;
import com.example.furniture.demo.repository.FurnitureDetailRepository;
import com.example.furniture.demo.service.FurnitureDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FurnitureDetailServiceImpl implements FurnitureDetailService {

    private final FurnitureDetailRepository furnitureDetailRepository;
    private final FurnitureMapper furnitureMapper;

    @Override
    public List<FurnitureDTO> getAllFurnitures() {
        return furnitureDetailRepository.findAll()
                .stream().map(furnitureDetail -> furnitureMapper.fromEntity(furnitureDetail)).toList();
    }

    @Override
    public FurnitureDTO getFurnitureById(Long id) {
        return furnitureMapper.fromEntity(
                furnitureDetailRepository.findById(id)
                        .orElseThrow(()->new NoSuchElementException("There is not furniture with id " +id)));
    }

    @Override
    @Transactional
    public void createFurniture(FurnitureDTO furnitureDTO) {
        furnitureDetailRepository.save(furnitureMapper.toEntity(furnitureDTO));
    }

    @Override
    @Transactional
    public void updateFurniture(FurnitureDTO furnitureDTO) {
        getFurnitureById(furnitureDTO.getId());

        furnitureDetailRepository.save(furnitureMapper.toEntity(furnitureDTO));
    }
}
