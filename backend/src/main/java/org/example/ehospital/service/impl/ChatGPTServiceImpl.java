package org.example.ehospital.service.impl;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.ehospital.service.ChatGPTService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {
    private final WebClient webClient;
    private final String apiKey;

    public ChatGPTServiceImpl(WebClient webClient, Dotenv dotenv) {
        this.webClient = webClient;
        this.apiKey = dotenv.get("API_KEY");
    }

    @Override
    public Map<String, String> generateSuggestions(String prompt) {
        try {
            Map<String, Object> response = webClient.post()
                    .uri("/chat/completions")
                    .header("Authorization", "Bearer " + apiKey)
                    .bodyValue(Map.of(
                            "model", "gpt-4o-mini",
                            "messages", List.of(
                                    Map.of("role", "system", "content", "You are a medical assistant."),
                                    Map.of("role", "user", "content", prompt)
                            ),
                            "max_tokens", 500,
                            "temperature", 0.9
                    ))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            // Parse the API response
            String content = (String) ((Map<String, Object>) ((List<Map<String, Object>>) response.get("choices"))
                    .get(0)
                    .get("message"))
                    .get("content");

            // Split the response into hospitalization steps and prescription
            String[] parts = content.split("\n\nPRESCRIPTION:");
            String hospitalizationSteps = parts[0].trim();
            String prescription = parts.length > 1 ? parts[1].trim() : "";

            return Map.of(
                    "hospitalizationSteps", hospitalizationSteps,
                    "prescription", prescription
            );

        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error calling ChatGPT API: " + e.getResponseBodyAsString(), e);
        }
    }
}