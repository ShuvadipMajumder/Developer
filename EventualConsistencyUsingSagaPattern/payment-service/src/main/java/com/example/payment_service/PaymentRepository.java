package com.example.payment_service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.payment_service.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
