package com.example.spring_resource_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@GetMapping("/hello")
	public String getMessage() {
		System.out.println("Inside resource getMessage /hello");
		return "Hello from Resource Server!";
	}
	

}
