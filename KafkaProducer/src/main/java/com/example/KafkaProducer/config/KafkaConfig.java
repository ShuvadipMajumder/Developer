package com.example.KafkaProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.example.KafkaProducer.constant.AppConstant;

@Configuration
public class KafkaConfig {

	public NewTopic topic(){
		
		return TopicBuilder
				.name(AppConstant.TOPIC_NAME)
				.build();
	}
}

