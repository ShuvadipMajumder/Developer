package com.example.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.webclient.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {

	@Autowired
	private WebClient webClient;

	public Flux<Post> getAllPosts() {
		return webClient.get().uri("/posts") // This returns a JSON array of posts
				.retrieve().bodyToFlux(Post.class); // Deserialize as stream of Post
	}

	// Add Logging to See Parallel Nature
	public Mono<String> getPostTitleById(int id) {
		System.out.println("Calling API for post " + id + " on thread " + Thread.currentThread().getName());
		return webClient.get().uri("/posts/{id}", id).retrieve().bodyToMono(String.class)
				.doOnNext(resp -> System.out.println("Completed post " + id));
	}
}
