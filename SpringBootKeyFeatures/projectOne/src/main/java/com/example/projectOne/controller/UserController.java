package com.example.projectOne.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectOne.entity.User;
import com.example.projectOne.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        // This method will return a list of all users
        // For now, we will just return a simple message
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        // This method will create a new user
        // For now, we will just return the created user
        return userService.createUser(user);
    }
    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        // This method will delete a user by ID
        // For now, we will just return a simple message
        userService.deleteUser(id);
    }

}
