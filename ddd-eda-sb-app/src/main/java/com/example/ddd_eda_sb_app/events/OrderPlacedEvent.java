package com.example.ddd_eda_sb_app.events;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_events")
public class OrderPlacedEvent {

    @Id
    private String id;

    private String orderId;
    private String bookTitle;
    private LocalDateTime placedAt;

    public OrderPlacedEvent() {
        // Default constructor required by JPA
    }

    public OrderPlacedEvent(String orderId, String bookTitle) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.bookTitle = bookTitle;
        this.placedAt = LocalDateTime.now();
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }
}
