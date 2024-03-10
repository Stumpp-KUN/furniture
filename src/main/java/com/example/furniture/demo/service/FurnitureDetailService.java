package com.example.furniture.demo.service;

import com.example.furniture.demo.dto.FurnitureDTO;

import java.util.List;

public interface FurnitureDetailService {
    List<FurnitureDTO> getAllFurnitures();
    FurnitureDTO getFurnitureById(Long id);
    void createFurniture(FurnitureDTO furnitureDTO);
    void updateFurniture(FurnitureDTO furnitureDTO);
}
