package com.example.oauth2_okta_provider.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        return authentication; // Returns authenticated user details
    }
}

