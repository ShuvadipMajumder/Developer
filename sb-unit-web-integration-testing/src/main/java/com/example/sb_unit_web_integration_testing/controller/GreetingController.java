package com.example.sb_unit_web_integration_testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb_unit_web_integration_testing.service.GreetingService;

@RestController
@RequestMapping("/api")
public class GreetingController {

	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return greetingService.greet(name);
	}

}
