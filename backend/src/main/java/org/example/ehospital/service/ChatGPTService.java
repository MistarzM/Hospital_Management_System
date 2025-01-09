package org.example.ehospital.service;

import java.util.Map;

public interface ChatGPTService {
    Map<String, String> generateSuggestions(String prompt);
}