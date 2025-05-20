package com.example.okta_demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OktaDemoController {
	
	//Get the Bearer token from okta 
	//https://<okta domain>/oauth2/default/v1/token
	//Username =<Client id>
	//Password =<Client secret>
	//grant_type= client_credentials
	//scope= <customescope>
	
	//Use the token to http://localhost:8080/okta
	//Bearer Token=<>
	@GetMapping("/okta")
	public ResponseEntity<String> getName() {
		
		return new ResponseEntity<>("Hello Secured User!", HttpStatus.OK);
		
	}
	

}
