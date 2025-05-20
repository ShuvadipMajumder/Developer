package com.example.gemini_chat.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ChatService {
	
	// Access to APIKey and URL [Gemini]
    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;
    
    private final WebClient webClient;

	public ChatService(WebClient.Builder webClient) {
		this.webClient = webClient.build();
	}
    
	public String getAnswer(String question) {
		
		// Construct the request payload
		//{	"contents": [{"parts":[{"text": "Explain how AI works"}]
		//			    }]
		//}
		Map<String, Object> requestBody= Map.of("contents", new Object[] {
				Map.of("parts",new Object[] {
						Map.of("text", question)
				})
		});
		
		// Make API Call
		String response = webClient.post()
				.uri(geminiApiUrl+geminiApiKey)
				.header("Content-Type","application/json")
				.bodyValue(requestBody)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		// Return response
        return response;
		
	}

}
