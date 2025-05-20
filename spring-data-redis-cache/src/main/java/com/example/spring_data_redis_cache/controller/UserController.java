package com.example.spring_data_redis_cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_data_redis_cache.entity.User;
import com.example.spring_data_redis_cache.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		
		User user = userService.getUserById(id);
		return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	System.out.println("inside createUser user : "+user.toString());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
	

}
