package advJava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Use ExecutorService instead of raw Thread / Runnable
//Managed thread pool	Best for production — scalable and clean
public class MultithreadingExample {

	public static void main(String[] args) {

		// newFixedThreadPool maintains a fixed number of threads, determined at
		// creation. If more tasks are submitted than available threads, the excess
		// tasks are placed in a queue and wait for a thread to become available.
		
		// ExecutorService executorService = Executors.newFixedThreadPool(4);

		// newCachedThreadPool dynamically creates new threads as needed to handle
		// submitted tasks. It reuses previously created threads if they are available.
		// Idle threads that have not been used for a specified period (typically 60
		// seconds) are terminated and removed from the pool.
		
		ExecutorService executorService = Executors.newCachedThreadPool();

		// Simulate 10 tasks
		for (int i = 1; i <= 10; i++) {
			int taskId = i;

			executorService.submit(() -> {
				System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
				try {
					Thread.sleep(2000); // Simulate processing
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.err.println("Task " + taskId + " interrupted.");
				}
				System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
			});

		}
		
		//Exception handling simulation and handling
//		Future<?> future = executorService.submit(() -> {
//            throw new RuntimeException("Task failed!");
//        });
//		try {
//            future.get(); // Will re-throw the exception
//        } catch (ExecutionException e) {
//            System.err.println("Exception: " + e.getCause().getMessage());
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
		
		executorService.shutdown();

	}
}
