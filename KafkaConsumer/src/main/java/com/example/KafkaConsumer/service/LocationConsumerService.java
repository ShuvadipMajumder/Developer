package com.example.KafkaConsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LocationConsumerService {
	
	@KafkaListener(topics="kafka-test-topic", groupId="user-group")
	public void phLocation(String location) {
		System.out.println("Inside LocationConsumerService phLocation : "+location);
	}

}
