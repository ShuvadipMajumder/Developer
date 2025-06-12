package com.example.ddd_eda_sb_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ddd_eda_sb_app.events.OrderPlacedEvent;

public interface OrderPlacedEventRepository extends JpaRepository<OrderPlacedEvent, String> {
    // This interface will automatically provide CRUD operations for
    // OrderPlacedEvent entities
    // No additional methods are needed as JpaRepository provides all necessary
    // methods

}
