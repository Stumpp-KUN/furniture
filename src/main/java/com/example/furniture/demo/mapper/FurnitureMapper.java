package com.example.furniture.demo.mapper;

import com.example.furniture.demo.dto.FurnitureDTO;
import com.example.furniture.demo.entity.FurnitureDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FurnitureMapper {
    FurnitureDetail toEntity(FurnitureDTO furnitureDTO);
    FurnitureDTO fromEntity(FurnitureDetail furnitureDetail);
}
