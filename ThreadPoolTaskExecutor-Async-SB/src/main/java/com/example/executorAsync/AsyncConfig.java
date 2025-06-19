package com.example.executorAsync;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Bean(name = "customExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);       // Minimum threads
        executor.setMaxPoolSize(5);        // Max threads
        executor.setQueueCapacity(100);     // Queue size
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }
    
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    	return (throwable, method, params) -> {
    		
    		System.err.println("Exception in async method: " + method.getName());
            System.err.println("Message: " + throwable.getMessage());
    	};
    }
}