package com.example.consumer_service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	private final RestTemplate restTemplate;

	public ConsumerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/products")
	public List<String> getProducts() {
		String prodServiceUrl = "http://product-service/products";
		return restTemplate.getForObject(prodServiceUrl, List.class);
	}

}
