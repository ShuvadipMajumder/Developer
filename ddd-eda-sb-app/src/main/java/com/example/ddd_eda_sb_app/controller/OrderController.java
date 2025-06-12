package com.example.ddd_eda_sb_app.controller;

import com.example.ddd_eda_sb_app.events.OrderPlacedEvent;
import com.example.ddd_eda_sb_app.model.Order;
import com.example.ddd_eda_sb_app.repository.OrderPlacedEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final ApplicationEventPublisher eventPublisher;
    private final OrderPlacedEventRepository orderPlacedEventRepository;

    @Autowired
    public OrderController(ApplicationEventPublisher eventPublisher,
            OrderPlacedEventRepository orderPlacedEventRepository) {
        this.eventPublisher = eventPublisher;
        this.orderPlacedEventRepository = orderPlacedEventRepository;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        // Generate a unique order ID
        String orderId = UUID.randomUUID().toString();

        // Create an OrderPlacedEvent
        OrderPlacedEvent event = new OrderPlacedEvent(orderId, order.getBookTitle());
        System.out.println("Order placed with ID: " + orderId);

        // Publish the event
        eventPublisher.publishEvent(event);
        System.out.println("Event published: " + event.getId());

        // Save the event to the repository
        orderPlacedEventRepository.save(event);
        System.out.println("Event saved to repository: " + event.getId());

        // Return the order ID
        return orderId;
    }

}
