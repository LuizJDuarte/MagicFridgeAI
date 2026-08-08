package dev.java10x.MagicFridgeAI.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public class GeminiService {

    private final WebClient webClient;
    private String apiKey = System.getenv("GEMINI_API_KEY");

    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateRecipe(){
        String prompt = "Me sugira uma receita simples com ingredientes comuns";
        Map<String, Object> requestBody = Map.of(
                "model", "gemini-3.5-flash",
                "messages", List.of(
                        Map.of("role","system","content","Você é um assistente que cria receitas"),
                        Map.of("role","user","content",prompt)

                )
        );
        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer"+apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choice");
                    if(choices != null && !choices.isEmpty()){
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma receita foi gerada";
                });
    }
}
