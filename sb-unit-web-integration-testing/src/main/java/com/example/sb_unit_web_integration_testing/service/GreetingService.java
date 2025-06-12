package com.example.sb_unit_web_integration_testing.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String greet(String name) {
		return "Hello " + name + "!";
	}

}
