package com.example.order_service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order_service.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
