package com.example.jwt_auth.controllers;

import com.example.jwt_auth.config.JwtUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtils jwtUtils;

    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        String token = jwtUtils.generateToken(user.get("username"));
        return Map.of("token", token);
    }
}

