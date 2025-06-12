package com.example.sb_unit_web_integration_testing.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void fullAppGreetTest() {
		ResponseEntity<String> response = testRestTemplate.getForEntity("/api/greet?name=Charlie", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello Charlie!");
	}

}
