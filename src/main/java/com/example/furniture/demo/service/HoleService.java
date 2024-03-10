package com.example.furniture.demo.service;

import com.example.furniture.demo.dto.HoleDTO;

import java.util.List;

public interface HoleService {
    List<HoleDTO> getAllHoles();
    HoleDTO getHole(Long id);
    void createHole(HoleDTO holeDTO);
    void createWithPattern(HoleDTO holeDTO, String code);
    void updateHole(HoleDTO holeDTO);
}
