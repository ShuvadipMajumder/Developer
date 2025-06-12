package com.example.idempotency_sb_rest_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestBody Order order) {

        try {
            System.out.println("Received Idempotency-Key: " + idempotencyKey);
            if (orderService.isDuplicate(idempotencyKey)) {
                Order existing = orderService.getOrder(idempotencyKey);
                System.out.println("Returning existing order: " + existing);
                return ResponseEntity.ok(existing);
            }

            // Save new order (in real app, persist to DB)
            orderService.saveOrder(idempotencyKey, order);
            System.out.println("Saved new order: " + order);
            return ResponseEntity.status(201).body(order);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing order");
        }
    }
}
