package com.example.okta_oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/public")
	public String publicApi() {
		System.out.println("Inside publicApi");
		return "Response from public emdpoint";
	}
	
	@GetMapping("/private")
	public String privateApi() {
		System.out.println("Inside privateApi");
		return "Response from private emdpoint";
	}
	

}
