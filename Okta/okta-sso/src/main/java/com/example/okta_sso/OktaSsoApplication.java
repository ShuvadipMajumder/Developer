package com.example.okta_sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//we can make the app up with both ports and use one sso to login for other
//http://localhost:8080/hello
//http://localhost:8081/hello

@SpringBootApplication
public class OktaSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktaSsoApplication.class, args);
	}

}
