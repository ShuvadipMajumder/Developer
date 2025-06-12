package com.example.idempotency_sb_rest_api;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import java.io.IOException;

@Configuration
public class RedisConfig {

    private RedisServer redisServer;

    public RedisConfig() throws IOException {
        this.redisServer = new RedisServer(6379);
        this.redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}
