package com.example.gemini_chat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gemini_chat.service.ChatService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class AIController {	
	private final ChatService chatService;

	public AIController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	//http://localhost:8080/api/ask
	//Body raw
	//{
	//    "question": "what is the total population of USA"
	//}
	@PostMapping("/ask")
	public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload) {
		String question = payload.get("question");
		System.out.println("question : "+question);
		String answer = chatService.getAnswer(question);
		return ResponseEntity.ok(answer);
	}
	

	
	
}
