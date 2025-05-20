package com.example.KafkaProducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.KafkaProducer.constant.AppConstant;

@Service
public class LocationService {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		kafkaTemplate.send(AppConstant.TOPIC_NAME, location);
		System.out.println("Inside LocationService updateLocation after kafkaTemplate send");
		return true;
	}

}
