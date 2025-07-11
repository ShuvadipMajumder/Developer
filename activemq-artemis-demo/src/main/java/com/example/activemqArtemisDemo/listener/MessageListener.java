package com.example.activemqArtemisDemo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @JmsListener(destination = "demo.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}

