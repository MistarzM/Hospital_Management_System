package org.example.ehospital.controller;

import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/triage")
public class TriageController {
    private final TriageService triageService;

    @Autowired
    public TriageController(TriageService triageService) {
        this.triageService = triageService;
    }

    @PostMapping
    public ResponseEntity<TriageDto> createTriage(@RequestBody TriageDto triageDto) {
        TriageDto savedTriage = triageService.createTriage(triageDto);
        return new ResponseEntity<>(savedTriage, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TriageDto> getTriageById(@PathVariable("id") Integer id) {
        TriageDto triageDto = triageService.getTriageById(id);
        return new ResponseEntity<>(triageDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TriageDto>> getAllTriages() {
        List<TriageDto> triages = triageService.getAllTriages();
        return new ResponseEntity<>(triages, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TriageDto> updateTriage(@PathVariable("id") Integer id, @RequestBody TriageDto updatedTriage) {
        TriageDto triageDto = triageService.updateTriage(id, updatedTriage);
        return new ResponseEntity<>(triageDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTriage(@PathVariable("id") Integer id) {
        triageService.deleteTriage(id);
        return ResponseEntity.ok("Triage deleted successfully");
    }
}
