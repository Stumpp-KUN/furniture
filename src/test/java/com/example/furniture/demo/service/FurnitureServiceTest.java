package com.example.furniture.demo.service;

import com.example.furniture.demo.dto.FurnitureDTO;
import com.example.furniture.demo.entity.FurnitureDetail;
import com.example.furniture.demo.mapper.FurnitureMapper;
import com.example.furniture.demo.repository.FurnitureDetailRepository;
import com.example.furniture.demo.service.impl.FurnitureDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FurnitureServiceTest {

    @Mock
    private FurnitureDetailRepository furnitureDetailRepository;

    @Mock
    private FurnitureMapper furnitureMapper;

    @InjectMocks
    private FurnitureDetailServiceImpl furnitureDetailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFurnitures() {
        FurnitureDetail furnitureDetail = new FurnitureDetail();
        when(furnitureDetailRepository.findAll()).thenReturn(Collections.singletonList(furnitureDetail));
        when(furnitureMapper.fromEntity(furnitureDetail)).thenReturn(new FurnitureDTO());

        assertEquals(1, furnitureDetailService.getAllFurnitures().size());
        verify(furnitureDetailRepository, times(1)).findAll();
    }

    @Test
    void testGetFurnitureById() {
        FurnitureDetail furnitureDetail = new FurnitureDetail();
        furnitureDetail.setId(1L);
        FurnitureDTO furnitureDTO = new FurnitureDTO();
        furnitureDTO.setId(1L);
        when(furnitureDetailRepository.findById(1L)).thenReturn(Optional.of(furnitureDetail));
        when(furnitureMapper.fromEntity(furnitureDetail)).thenReturn(furnitureDTO);

        FurnitureDTO result = furnitureDetailService.getFurnitureById(1L);

        assertEquals(1L, result.getId().longValue());
        verify(furnitureDetailRepository, times(1)).findById(1L);
    }

    @Test
    void testGetFurnitureById_NotFound() {
        when(furnitureDetailRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> furnitureDetailService.getFurnitureById(1L));
        verify(furnitureDetailRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateFurniture() {
        FurnitureDTO furnitureDTO = new FurnitureDTO();
        furnitureDetailService.createFurniture(furnitureDTO);

        verify(furnitureDetailRepository, times(1)).save(any());
    }

    @Test
    void testUpdateFurniture() {
        FurnitureDTO furnitureDTO = new FurnitureDTO();
        furnitureDTO.setId(1L);
        when(furnitureDetailRepository.findById(1L)).thenReturn(Optional.of(new FurnitureDetail()));

        furnitureDetailService.updateFurniture(furnitureDTO);

        verify(furnitureDetailRepository, times(1)).save(any());
    }

    @Test
    void testUpdateFurniture_NotFound() {
        FurnitureDTO furnitureDTO = new FurnitureDTO();
        furnitureDTO.setId(1L);
        when(furnitureDetailRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> furnitureDetailService.updateFurniture(furnitureDTO));
    }
}

