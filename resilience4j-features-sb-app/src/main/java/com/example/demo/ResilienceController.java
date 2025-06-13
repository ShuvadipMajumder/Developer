package com.example.demo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/api")
public class ResilienceController {

	// simulate CircuitBreaker
	// Hit http://localhost:8080/api/unstable several times.
	// After 3+ failures, the fallback will trigger even for healthy calls.

	private final Random random = new Random();

	@GetMapping("/unstable")
	@CircuitBreaker(name = "circuitBreakerInstance", fallbackMethod = "circuitBreakerFallback")
	public String unstableService() {
		if (random.nextBoolean()) {
			throw new RuntimeException("Simulated failure");
		}
		return "Success!";
	}

	public String circuitBreakerFallback(Exception e) {
		return "@CircuitBreaker Fallback : Service temporarily unavailable. Please try later.";
	}

	// Simulate RateLimiter
	// Limits how many requests are allowed in a given time window.
	// Hit http://localhost:8080/api/limited quickly more than 2 times in 10
	// seconds. Fallback message will appear for extra requests.

	@GetMapping("/limited")
	@RateLimiter(name = "rateLimiterService", fallbackMethod = "rateLimiterFallback")
	public String rateLimitedApi() {
		return "Request successful";
	}

	public String rateLimiterFallback(RequestNotPermitted ex) {
		return "@RateLimiter Fallback: Too many requests - Try later!";
	}

	// Simulate Retry
	// Automatically re-attempts failed operations a set number of times.
	// Call /api/retry
	// You'll see fallback message after 3 retry attempts.

	@GetMapping("/retry")
	@Retry(name = "retryService", fallbackMethod = "retryFallback")
	public String retryExample() {
		throw new RuntimeException("Temporary Error");
	}

	public String retryFallback(Exception ex) {
		return "@Retry Fallback: Retried 3 times, still failed!";
	}

	// Simulate Bulkhead
	// Limits number of concurrent calls to prevent a failing service from consuming
	// all resources.
	// Open multiple browser tabs and hit http://localhost:8080/api/bulkhead at the
	// same time.
	// After 2 concurrent calls, others will get fallback.

	@GetMapping("/bulkhead")
	@Bulkhead(name = "bulkheadService", fallbackMethod = "bulkheadFallback")
	public String bulkheadExample() throws InterruptedException {
		Thread.sleep(5000); // Simulate delay
		return "Bulkhead Success";
	}

	public String bulkheadFallback(Throwable t) {
		return "@Bulkhead Fallback : Too many concurrent calls - try later";
	}

	// Simulate TimeLimiter
	// Stops waiting for a service call if it takes too long.
	// Call /api/timelimit
	// It will timeout in 2 seconds and fallback, since service sleeps for 5
	// seconds.

	@GetMapping("/timelimit")
	@TimeLimiter(name = "timeLimitService", fallbackMethod = "timeoutFallback")
	public CompletableFuture<String> timeLimitExample() {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000); // simulate delay
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Completed";
		});
	}

	public CompletableFuture<String> timeoutFallback(Throwable ex) {
		return CompletableFuture.completedFuture("@TimeLimiter Fallback: Timeout! Try later.");
	}

}
