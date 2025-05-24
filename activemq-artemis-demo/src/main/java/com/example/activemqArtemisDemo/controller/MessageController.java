package com.example.activemqArtemisDemo.controller;

import com.example.activemqArtemisDemo.service.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public String send(@RequestParam String content) {
        messageProducer.sendMessage(content);
        return "Message sent: " + content;
    }
}
