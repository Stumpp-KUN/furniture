package com.example.furniture.demo.service;

import com.example.furniture.demo.dto.FurnitureDTO;
import com.example.furniture.demo.dto.HoleDTO;

public interface PatternService {
    HoleDTO calculateHoleByPattern(FurnitureDTO furnitureDTO, HoleDTO holeDTO, String code);
}
