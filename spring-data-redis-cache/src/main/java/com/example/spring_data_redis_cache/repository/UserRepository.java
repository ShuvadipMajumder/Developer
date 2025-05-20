package com.example.spring_data_redis_cache.repository;

import org.springframework.stereotype.Repository;

import com.example.spring_data_redis_cache.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
