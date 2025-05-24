package com.example.activemqArtemisDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.jms.Queue;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;

@Configuration
public class JmsConfig {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("demo.queue");
    }
}