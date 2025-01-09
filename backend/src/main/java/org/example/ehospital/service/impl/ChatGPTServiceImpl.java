package org.example.ehospital.service.impl;

import org.example.ehospital.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {
    private final WebClient webClient;

    @Autowired
    public ChatGPTServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Map<String, String> generateSuggestions(String prompt) {
        try {
            // Call ChatGPT API
            Map<String, Object> response = webClient.post()
                    .uri("/chat/completions")
                    .header("Authorization", "Bearer") // Replace with your API key
                    .bodyValue(Map.of(
                            "model", "gpt-3.5-turbo", // ChatGPT model
                            "messages", List.of(
                                    Map.of("role", "system", "content", "You are a medical assistant."),
                                    Map.of("role", "user", "content", prompt)
                            ),
                            "max_tokens", 500,
                            "temperature", 0.7
                    ))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            // Extract response from "choices" field
            String reply = ((List<Map<String, Object>>) response.get("choices"))
                    .get(0)
                    .get("message")
                    .toString();

            // Transform response into application data
            Map<String, String> suggestions = Map.of(
                    "hospitalizationSteps", "Example hospitalization steps: " + reply,
                    "prescription", "Example prescription: " + reply
            );

            return suggestions;

        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error calling ChatGPT API: " + e.getResponseBodyAsString(), e);
        }
    }
}