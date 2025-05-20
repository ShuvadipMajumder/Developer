package com.example.spring_oauth_client.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ClientController {
	
	@Autowired
	private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
	
	@GetMapping("/message")
	public String getMessageFromResource(Principal principal) {
		System.out.println("Inside client getMessageFromResource principal.getName() : "+principal.getName());		
		
		String accessToken = oAuth2AuthorizedClientService
				.loadAuthorizedClient("reg-client", principal.getName())
				.getAccessToken().getTokenValue();
		System.out.println("Inside client getMessageFromResource accessToken : "+accessToken);		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer " + accessToken);
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		var restTemplate = new RestTemplate();
		
		ResponseEntity<String> responseEntity = 
				restTemplate.exchange("http://127.0.0.1:8080/hello", HttpMethod.GET, httpEntity, String.class);
		System.out.println("Inside client getMessageFromResource responseEntity : "+responseEntity);
		return "Success from client after getting resource :: " + responseEntity.getBody();
	}
	

}
