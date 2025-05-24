package com.example.activemqArtemisDemo.service;

import jakarta.jms.Queue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    public MessageProducer(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(queue, message);
    }
}