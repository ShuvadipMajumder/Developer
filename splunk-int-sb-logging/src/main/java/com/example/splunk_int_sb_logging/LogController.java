package com.example.splunk_int_sb_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);

	@GetMapping
	public String logSomething(@RequestParam(defaultValue = "info") String level) {
		switch (level.toLowerCase()) {
		case "debug":
			logger.debug("Debug log from Spring Boot");
			break;
		case "warn":
			logger.warn("Warning log from Spring Boot");
			break;
		case "error":
			logger.error("Error log from Spring Boot");
			break;
		default:
			logger.info("Info log from Spring Boot");
			break;
		}
		return "Log sent!";
	}
}
