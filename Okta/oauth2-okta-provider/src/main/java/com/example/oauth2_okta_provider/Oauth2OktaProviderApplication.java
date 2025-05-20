package com.example.oauth2_okta_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2OktaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2OktaProviderApplication.class, args);
	}
	
	/*
	 * Running the Application
	 * Start your Spring Boot app.
	 * Visit http://localhost:8080/oauth2/authorization/okta to initiate login.
	 * Log in with your Okta account.
	 * After authentication, Spring Security will fetch user details from user-info-uri.
	 * Access http://localhost:8080/user to see authenticated user details.
	 */

}
