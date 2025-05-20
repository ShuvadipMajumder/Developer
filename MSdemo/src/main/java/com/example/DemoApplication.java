package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Logger logger=LoggerFactory.getLogger(DemoApplication.class);
		logger.info("Inside Main");
		SpringApplication.run(DemoApplication.class, args);
	}

}
