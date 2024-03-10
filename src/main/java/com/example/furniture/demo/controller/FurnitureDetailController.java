package com.example.furniture.demo.controller;

import com.example.furniture.demo.dto.FurnitureDTO;
import com.example.furniture.demo.service.FurnitureDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/furnitures")
public class FurnitureDetailController {
    private final FurnitureDetailService furnitureDetailService;

    @GetMapping("/collect")
    public ResponseEntity<List<FurnitureDTO>> getAllFurnitures() {
        return new ResponseEntity<>(furnitureDetailService.getAllFurnitures(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FurnitureDTO> getFurnitureById(Long id) {
        return new ResponseEntity<>(furnitureDetailService.getFurnitureById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public void createFurniture(@RequestBody @Valid FurnitureDTO furnitureDTO) {
        furnitureDetailService.createFurniture(furnitureDTO);
    }

    @PutMapping("/update")
    public void updateFurniture(@RequestBody @Valid FurnitureDTO furnitureDTO) {
        furnitureDetailService.updateFurniture(furnitureDTO);
    }
}
