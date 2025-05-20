package com.example.demoOauth2.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {
	
	@RequestMapping("/oauth2Login")
	public ResponseEntity<String> sayHello(Principal principal){
		return new ResponseEntity<>("Hello "+principal, HttpStatus.OK);
	}

}
