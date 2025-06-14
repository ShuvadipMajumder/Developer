package com.example.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        return ResponseEntity.ok(service.placeOrder(orders.getProduct(), orders.getAmount()));
    }
}
