package org.example.ehospital;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://api.openai.com/v1").build();
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure().load();
    }
}
