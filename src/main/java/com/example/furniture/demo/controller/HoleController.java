package com.example.furniture.demo.controller;

import com.example.furniture.demo.dto.HoleDTO;
import com.example.furniture.demo.service.HoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/holes")
public class HoleController {

    private final HoleService holeService;

    @GetMapping("/collect")
    public ResponseEntity<List<HoleDTO>> getAllHoles() {
        return new ResponseEntity<>(holeService.getAllHoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoleDTO> getHoleById(@PathVariable Long id) {
        return new ResponseEntity<>(holeService.getHole(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public void createHole(@RequestBody @Valid HoleDTO holeDTO) {
        holeService.createHole(holeDTO);
    }

    @PostMapping("/pattern")
    public void createHoleWithPattern(@RequestBody @Valid HoleDTO holeDTO, String code) {
        holeService.createWithPattern(holeDTO, code);
    }

    @PutMapping("/update")
    public void updateHole(@RequestBody @Valid HoleDTO holeDTO) {
        holeService.updateHole(holeDTO);
    }
}
