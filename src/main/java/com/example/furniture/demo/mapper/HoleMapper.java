package com.example.furniture.demo.mapper;

import com.example.furniture.demo.dto.HoleDTO;
import com.example.furniture.demo.entity.Hole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HoleMapper {
    Hole toEntity(HoleDTO holeDTO);
    HoleDTO fromEntity(Hole hole);
}
