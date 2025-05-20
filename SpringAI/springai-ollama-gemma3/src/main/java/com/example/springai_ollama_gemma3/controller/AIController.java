package com.example.springai_ollama_gemma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springai_ollama_gemma3.service.AIService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ai")
public class AIController {
	
	@Autowired
	AIService aiService;
	
	@PostMapping("/chat")
	public String getChatResponse(@RequestParam String cat, String yr) {
		return aiService.getChatResponse(cat, yr);
	}
	
	
	@PostMapping("/summ")
	public String getSummary(@RequestBody String text) {
		return aiService.getSummary(text);
	}
	
	@GetMapping("/image")
	public String getMultimodalResponse() {
		return aiService.getMultimodalResponse();
	}
	

}
