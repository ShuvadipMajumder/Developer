package com.example.sb_unit_web_integration_testing.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.sb_unit_web_integration_testing.service.GreetingService;

public class GreetingServiceTest {

	@Test
	void testGreet() {
		GreetingService greetingService = new GreetingService();
		String result = greetingService.greet("Alice");
		assertEquals("Hello Alice!", result);
	}

}
