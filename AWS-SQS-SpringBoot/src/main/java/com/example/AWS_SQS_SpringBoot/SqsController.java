package com.example.AWS_SQS_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqsController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.endpoint.url}")
    private String endpoint;

    @GetMapping("/send/{message}")
    public void sendMessageToQueue(@PathVariable String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

    @SqsListener("${cloud.aws.sqs.queue-name}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

}
