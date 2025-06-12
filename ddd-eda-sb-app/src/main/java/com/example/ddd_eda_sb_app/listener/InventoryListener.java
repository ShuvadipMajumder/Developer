package com.example.ddd_eda_sb_app.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.ddd_eda_sb_app.events.OrderPlacedEvent;

@Component
public class InventoryListener {
    @EventListener
    public void handleInventory(OrderPlacedEvent event) {
        System.out.println("Inventory reserved for: " + event.getBookTitle());
    }
}
