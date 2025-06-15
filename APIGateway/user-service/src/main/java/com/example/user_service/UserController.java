package com.example.user_service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{id}")
	public Map<String, String> getUser(@PathVariable String id) {
		return Map.of("id", id, "name", "John Doe");
	}

}
