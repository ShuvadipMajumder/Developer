package com.example.executorAsync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private BackgroundService backgroundService;

    @GetMapping("/start")
    public String startTasks() {
        for (int i = 1; i <= 10; i++) {
            backgroundService.runTask("Task-" + i);
        }
        return "Tasks submitted!";
    }
    
    @GetMapping("/exception")
    public String start() {
    	backgroundService.runAsyncExceptionTask();
        return "Async Exception Task Started!";
    }
}
