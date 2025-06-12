package com.example.idempotency_sb_rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OrderService {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;
    private static final long TTL_SECONDS = 300; // 5 minutes

    public OrderService(StringRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public boolean isDuplicate(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public Order getOrder(String key) throws Exception {
        String json = redisTemplate.opsForValue().get(key);
        return objectMapper.readValue(json, Order.class);
    }

    public void saveOrder(String key, Order order) throws Exception {
        String json = objectMapper.writeValueAsString(order);
        redisTemplate.opsForValue().set(key, json, TTL_SECONDS, TimeUnit.SECONDS);
    }
}
