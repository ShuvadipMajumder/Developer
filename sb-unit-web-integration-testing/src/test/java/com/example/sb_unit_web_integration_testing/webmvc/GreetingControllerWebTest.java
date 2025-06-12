package com.example.sb_unit_web_integration_testing.webmvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.sb_unit_web_integration_testing.controller.GreetingController;
import com.example.sb_unit_web_integration_testing.service.GreetingService;

@WebMvcTest(GreetingController.class)
public class GreetingControllerWebTest {

	@MockBean
	GreetingService greetingService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGreetEndpoint() throws Exception {

		// Mockito's when().thenReturn() is used for controlling the behavior of mocked
		// dependencies within your unit tests.
		when(greetingService.greet("Bob")).thenReturn("Hello Bob!");

		// mockMvc.perform() is used to simulate HTTP requests and test the behavior of
		// your Spring MVC controllers
		mockMvc.perform(get("/api/greet?name=Bob")).andExpect(status().isOk())
				.andExpect(content().string("Hello Bob!"));

	}

}
