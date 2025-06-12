package com.example.idempotency_sb_rest_api;

import java.io.Serializable;

public class Order implements Serializable {
    private String item;
    private int quantity;

    // Constructors
    public Order() {
    }

    public Order(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    // Getters and Setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}