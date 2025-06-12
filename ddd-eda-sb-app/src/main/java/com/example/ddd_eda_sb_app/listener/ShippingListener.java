package com.example.ddd_eda_sb_app.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.ddd_eda_sb_app.events.OrderPlacedEvent;

@Component
public class ShippingListener {
    @EventListener
    public void prepareShipping(OrderPlacedEvent event) {
        System.out.println("Shipping prepared for: " + event.getBookTitle());
    }
}
