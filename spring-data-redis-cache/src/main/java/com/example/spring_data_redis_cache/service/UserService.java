package com.example.spring_data_redis_cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.spring_data_redis_cache.entity.User;
import com.example.spring_data_redis_cache.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Cacheable(value = "users", key = "#id")
	public User getUserById(Long id) {
		System.out.println("Inside service getUserById");
		return userRepository.findById(id).orElse(null);
	}

	@CachePut(value = "users")
	public User saveUser(User user) {
		System.out.println("Inside service saveUser");
		return userRepository.save(user);
	}

	@CacheEvict(value = "users", key = "#id")
	public void deleteUser(Long id) {
		System.out.println("Inside service deleteUser");
		userRepository.deleteById(id);
	}

}
