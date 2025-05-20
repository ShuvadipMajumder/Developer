package com.example.okta_sso.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String sayHello(Principal pricipal) {
		
		return "Hello from " + pricipal.getName();
		
	}

}
