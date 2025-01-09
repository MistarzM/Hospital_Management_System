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

            // Extract sections using keywords
            String hospitalizationPlan = extractSection(content, "HOSPITALIZATION_PLAN:", "PRESCRIPTION:");
            String prescription = extractSection(content, "PRESCRIPTION:", null);

            return Map.of(
                    "hospitalizationSteps", hospitalizationPlan,
                    "prescription", prescription
            );

        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error calling ChatGPT API: " + e.getResponseBodyAsString(), e);
        }
    }

    // Utility method to extract sections based on keywords
    private String extractSection(String content, String startKeyword, String endKeyword) {
        int startIndex = content.indexOf(startKeyword);
        int endIndex = endKeyword != null ? content.indexOf(endKeyword) : content.length();

        if (startIndex == -1) {
            return ""; // Jeśli nie znaleziono sekcji, zwróć pusty ciąg
        }

        return content.substring(startIndex + startKeyword.length(), endIndex).trim();
    }
}