package com.example.furniture.demo.dto;

import com.example.furniture.demo.entity.FurnitureDetail;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoleDTO {
    Long id;
    @NotNull(message = "Diameter should not be null")
    Double diameter;
    @Size(min = 1, message = "Min depth size 1")
    Double depth;
    Double entrySpeed;
    Double exitSpeed;
    Double xCoordinate;
    Double yCoordinate;
    Double zCoordinate;

    FurnitureDetail furnitureDetail;
}
