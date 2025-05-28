package com.example.projectOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectOne.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for User entity
    // Additional custom query methods can be defined here if needed

}
