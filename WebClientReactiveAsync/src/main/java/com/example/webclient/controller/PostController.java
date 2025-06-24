package com.example.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webclient.model.Post;
import com.example.webclient.service.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public Flux<Post> getPosts() {
		return postService.getAllPosts();
	}

	// ✅ Reactive (Non-blocking) endpoint
	@GetMapping("/post/1")
	public Mono<String> getSinglePost() {
		return postService.getPostTitleById(1);
	}

	// ✅ Async parallel execution and return combined result
	@GetMapping("/posts/async")
	public Mono<String> getMultiplePostsAsync() {
		Mono<String> post1 = postService.getPostTitleById(1);
		Mono<String> post2 = postService.getPostTitleById(2);
		Mono<String> post3 = postService.getPostTitleById(3);

		return Mono.zip(post1, post2, post3).map(
				tuple -> "Post1: " + tuple.getT1() + "\n\nPost2: " + tuple.getT2() + "\n\nPost3: " + tuple.getT3());
	}
}
