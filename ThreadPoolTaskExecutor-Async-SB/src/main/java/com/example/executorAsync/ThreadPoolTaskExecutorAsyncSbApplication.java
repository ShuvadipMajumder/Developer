package com.example.executorAsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ThreadPoolTaskExecutorAsyncSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadPoolTaskExecutorAsyncSbApplication.class, args);
	}

}
