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
			Thread.sleep(1500); // simulating delay
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
	}

}
