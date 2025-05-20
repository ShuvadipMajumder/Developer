package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello Human!";
	}
	
	@RequestMapping("/help")
	public String help() {
		return "I'm here to help!";
	}

}
