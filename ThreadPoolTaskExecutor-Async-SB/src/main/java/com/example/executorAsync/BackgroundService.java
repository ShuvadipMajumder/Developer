package com.example.executorAsync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BackgroundService {

    @Async("customExecutor")
    public void runTask(String taskName) {
        System.out.println("Started: " + taskName + " on " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000); // Simulate task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed: " + taskName + " on " + Thread.currentThread().getName());
    }
    
    @Async
    public void runAsyncExceptionTask() {
        throw new RuntimeException("Async failure simulation!");
    }
}
