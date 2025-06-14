package com.example.payment_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentRepository repo;

	@PostMapping
	public ResponseEntity<String> pay(@RequestBody Payment payment) {
		if (payment.getAmount() != 1000) {
			payment.setStatus("FAILED");
			repo.save(payment);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("FAILED");
		}
		payment.setStatus("SUCCESS");
		repo.save(payment);
		return ResponseEntity.ok("SUCCESS");
	}
}
