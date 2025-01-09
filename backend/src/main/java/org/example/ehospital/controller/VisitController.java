package org.example.ehospital.controller;

import org.example.ehospital.dto.VisitDto;
import org.example.ehospital.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/visit")
public class VisitController {
    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/{triageId}")
    public ResponseEntity<VisitDto> getVisitByTriageId(@PathVariable("triageId") Integer triageId) {
        VisitDto visitDto = visitService.getVisitByTriageId(triageId);
        return new ResponseEntity<>(visitDto, HttpStatus.OK);
    }
}
