package com.example.furniture.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double diameter;
    private Double depth;
    private Double entrySpeed;
    private Double exitSpeed;
    private Double xCoordinate;
    private Double yCoordinate;
    private Double zCoordinate;

    @ManyToOne
    @JoinColumn(name = "furniture_detail_id")
    private FurnitureDetail furnitureDetail;

}
