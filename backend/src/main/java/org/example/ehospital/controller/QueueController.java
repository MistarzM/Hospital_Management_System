package org.example.ehospital.controller;

import org.example.ehospital.dto.QueueDto;
import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/queue")
public class QueueController {
    private final QueueService queueService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping()
    public ResponseEntity<List<QueueDto>> getPriorityQueue() {
        List<QueueDto> priorityQueue = queueService.getPriorityQueue();
        return new ResponseEntity<>(priorityQueue, HttpStatus.OK);
    }
}