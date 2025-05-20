package com.example.okta_oauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecuirty)throws Exception {
		httpSecuirty.authorizeHttpRequests(auth -> auth
				.requestMatchers("/","/api/public").permitAll()
				.anyRequest().authenticated()
				)
				.oauth2Login()
				.and()
				.oauth2ResourceServer()
				.jwt();
		return httpSecuirty.build();
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		return JwtDecoders.fromIssuerLocation(issuerUri);
	}

}
