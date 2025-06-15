package com.example.oauth2github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Oauth2GithubSbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2GithubSbAppApplication.class, args);
	}

	@GetMapping("/user")
	public String home(@AuthenticationPrincipal OAuth2User principal) {
		return principal != null ? "Hello, " + principal.getAttribute("login") : "Hello, Guest!";
	}

}
