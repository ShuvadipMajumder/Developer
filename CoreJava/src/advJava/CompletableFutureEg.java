package advJava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletableFuture;

//CompletableFuture is a class in Java that helps you run tasks asynchronously 
//(i.e., in the background) without blocking the main thread. 
//You can chain multiple tasks together and combine or handle their results when they’re ready.
public class CompletableFutureEg {

	// Simulate a task (like ordering pizza)
	public static String orderPizza() {
		try {
			Thread.sleep(2000); // simulating delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "🍕 Pizza ready!";
	}

	// Simulate another task (like ordering ice cream)
	public static String orderIceCream() {
		try {
			Thread.sleep(5000); // simulating delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "🍨 Ice cream ready!";
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		System.out.println("Order placed...");

		// Start both tasks in parallel
		CompletableFuture<String> pizzaFuture = CompletableFuture.supplyAsync(() -> orderPizza());
		CompletableFuture<String> iceCreamFuture = CompletableFuture.supplyAsync(() -> orderIceCream());

		// When both are ready, combine them
		CompletableFuture<String> combined = pizzaFuture.thenCombine(iceCreamFuture,
				(pizza, iceCream) -> pizza + " and " + iceCream + ". Let's party!");

		// Do other stuff here (non-blocking part)
		System.out.println("Meanwhile, I'm reading a book...");

		// Wait for the result and print it

		System.out.println(combined.get());

		System.out.println("Party time!");

		// Simulate exception and handling
		//Method 1
//		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//			if (true) {
//				throw new RuntimeException("Failed to fetch user data");
//			}
//			return "User: John Doe";
//		});
//		// ✅ Using .exceptionally() to handle failure and return fallback
//		future.exceptionally(ex -> {
//			System.err.println("Error: " + ex.getMessage());
//			return "Fallback User: Dave Halls";
//		}).thenAccept(result -> System.out.println("Result: " + result));
		
		//Method 2
//		CompletableFuture.supplyAsync(() -> {
//		    throw new RuntimeException("Oops again!");
//		})
//		.handle((result, ex) -> {
//		    if (ex != null) {
//		        System.err.println("Handled exception: " + ex.getMessage());
//		        return "Default User";
//		    }
//		    return result;
//		})
//		.thenAccept(System.out::println);
	}

}
