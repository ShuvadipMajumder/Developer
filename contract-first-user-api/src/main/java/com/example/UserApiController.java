package com.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.UsersApi;
import com.example.model.User;

@RestController
public class UserApiController implements UsersApi {

	private final Map<Integer, User> db = new ConcurrentHashMap<>();

	@Override
	public ResponseEntity<Void> usersPost(User user) {
		db.put(user.getId(), user);
		return ResponseEntity.status(201).build();
	}

	@Override
	public ResponseEntity<User> usersIdGet(Integer id) {
		User user = db.get(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
}
