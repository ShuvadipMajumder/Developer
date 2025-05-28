package com.example.projectOne.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CleanupScheduler {

    //@Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    @Scheduled(fixedRate = 60000) // Runs every 60 seconds for testing purposes
    public void performCleanup() {
        // Logic for cleanup task
        System.out.println("Performing scheduled cleanup task...");
        // Add your cleanup logic here, e.g., deleting old records, clearing caches, etc.
    }

}
