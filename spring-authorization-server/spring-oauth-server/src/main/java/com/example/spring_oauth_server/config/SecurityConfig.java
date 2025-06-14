package com.example.spring_oauth_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	@Bean
	UserDetailsService inMemoryUserDetailsManager() {
		var userBuilder = User.builder();
		UserDetails user1 = userBuilder.username("Shuvadip")
				//.password("{noop}password")
				.password("{bcrypt}$2a$10$Smgk4iacoRi6vHRxFUf47OIJferGMqKSG37yXRXHcVj3HkA7LU8n2")
				.roles("USER","ADMIN").build();
		return new InMemoryUserDetailsManager(user1);
	}

}
