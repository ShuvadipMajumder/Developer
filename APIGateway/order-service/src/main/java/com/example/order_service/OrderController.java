package com.example.order_service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/{id}")
	public Map<String, String> getOrder(@PathVariable String id) {
		return Map.of("OrderId", id, "item", "Laptop");
	}

}
