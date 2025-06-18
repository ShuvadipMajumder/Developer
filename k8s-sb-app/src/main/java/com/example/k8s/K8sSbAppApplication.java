package com.example.k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class K8sSbAppApplication {

	@GetMapping("/hello")
	public String greeting() {
		return "Hello from Kubernetes! App Deployed using Helm! ";
	}

	public static void main(String[] args) {
		SpringApplication.run(K8sSbAppApplication.class, args);
	}

}
