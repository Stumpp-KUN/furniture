package com.example.furniture.demo.service;

import com.example.furniture.demo.dto.HoleDTO;
import com.example.furniture.demo.entity.Hole;
import com.example.furniture.demo.mapper.HoleMapper;
import com.example.furniture.demo.repository.HoleRepository;
import com.example.furniture.demo.service.FurnitureDetailService;
import com.example.furniture.demo.service.PatternService;
import com.example.furniture.demo.service.impl.HoleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class HoleServiceTest {
    @Mock
    private HoleRepository holeRepository;

    @Mock
    private HoleMapper holeMapper;

    @InjectMocks
    private HoleServiceImpl holeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllHoles() {
        List<Hole> holes = new ArrayList<>();
        holes.add(new Hole());
        when(holeRepository.findAll()).thenReturn(holes);

        List<HoleDTO> holeDTOs = new ArrayList<>();
        holeDTOs.add(new HoleDTO());
        when(holeMapper.fromEntity(any())).thenReturn(new HoleDTO());

        List<HoleDTO> result = holeService.getAllHoles();

        assertEquals(1, result.size());
        verify(holeRepository, times(1)).findAll();
    }

    @Test
    void testGetHole() {
        Hole hole = new Hole();
        hole.setId(1L);
        HoleDTO holeDTO = new HoleDTO();
        holeDTO.setId(1L);
        when(holeRepository.findById(1L)).thenReturn(Optional.of(hole));
        when(holeMapper.fromEntity(hole)).thenReturn(holeDTO);

        HoleDTO result = holeService.getHole(1L);

        assertNotNull(result.getId());
        assertEquals(1L, result.getId().longValue());
        verify(holeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetHole_NotFound() {
        when(holeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> holeService.getHole(1L));
        verify(holeRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateHole() {
        HoleDTO holeDTO = new HoleDTO();
        Hole hole = new Hole();
        when(holeMapper.toEntity(holeDTO)).thenReturn(hole);

        holeService.createHole(holeDTO);

        verify(holeRepository, times(1)).save(hole);
    }

    @Test
    void testUpdateHole() {
        HoleDTO holeDTO = new HoleDTO();
        holeDTO.setId(1L);
        Hole existingHole = new Hole();
        when(holeRepository.findById(1L)).thenReturn(Optional.of(existingHole));
        Hole updatedHole = new Hole();
        when(holeMapper.toEntity(holeDTO)).thenReturn(updatedHole);

        holeService.updateHole(holeDTO);

        verify(holeRepository, times(1)).findById(1L);
        verify(holeRepository, times(1)).save(updatedHole);
    }

    @Test
    void testUpdateHole_NotFound() {
        HoleDTO holeDTO = new HoleDTO();
        holeDTO.setId(1L);
        when(holeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> holeService.updateHole(holeDTO));
        verify(holeRepository, times(1)).findById(1L);
    }
}
