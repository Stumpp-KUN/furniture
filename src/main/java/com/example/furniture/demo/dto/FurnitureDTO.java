package com.example.furniture.demo.dto;

import com.example.furniture.demo.entity.Hole;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FurnitureDTO {
    Long id;
    Double length;
    Double width;
    Double height;
    List<Hole> holes;
}
