package com.example.ddd_eda_sb_app.model;

public class Order {
    private final String orderId;
    private final String bookTitle;

    public Order(String orderId, String bookTitle) {
        this.orderId = orderId;
        this.bookTitle = bookTitle;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}