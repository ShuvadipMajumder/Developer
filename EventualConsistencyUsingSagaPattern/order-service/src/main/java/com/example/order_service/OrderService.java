package com.example.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	public Orders placeOrder(String product, double amount) {
		Orders order = new Orders();
		order.setProduct(product);
		order.setAmount(amount);
		order.setStatus("CREATED");

		// Save initial order
		Orders savedOrder = orderRepository.save(order);

		// Prepare payment request
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(savedOrder.getId());
		paymentRequest.setAmount(savedOrder.getAmount());

		try {
			// Call payment-service
			String response = restTemplate.postForObject("http://localhost:9091/payments", paymentRequest,
					String.class);
			if ("SUCCESS".equalsIgnoreCase(response)) {
				savedOrder.setStatus("COMPLETED");
			} else {
				savedOrder.setStatus("CANCELLED");
			}
		} catch (Exception e) {
			// In case payment-service is down or call fails
			savedOrder.setStatus("CANCELLED");
		}

		return orderRepository.save(savedOrder); // Save updated status
	}
}
