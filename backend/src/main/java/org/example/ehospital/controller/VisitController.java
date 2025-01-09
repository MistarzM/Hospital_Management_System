package org.example.ehospital.controller;

import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.service.ChatGPTService;
import org.example.ehospital.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/visit")
public class VisitController {
    private final TriageService triageService;
    private final ChatGPTService chatGPTService;

    @Autowired
    public VisitController(TriageService triageService, ChatGPTService chatGPTService) {
        this.triageService = triageService;
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/{id}/simulate")
    public ResponseEntity<Map<String, String>> simulateVisit(@PathVariable("id") Integer id) {
        // Pobierz dane pacjenta
        TriageDto triageDto = triageService.getTriageById(id);

        // Przygotuj prompt dla ChatGPT
        String prompt = String.format(
                "Pacjent: %s, Ciśnienie: %d, Tętno: %d, Saturacja: %d, Opis: %s. Zasugeruj dalsze kroki hospitalizacji i receptę.",
                triageDto.getName(),
                triageDto.getBloodPressure(),
                triageDto.getHeartRate(),
                triageDto.getOxygenSaturation(),
                triageDto.getDescription()
        );

        // Wywołaj API ChatGPT
        Map<String, String> suggestions = chatGPTService.generateSuggestions(prompt);

        return ResponseEntity.ok(suggestions);
    }
}



