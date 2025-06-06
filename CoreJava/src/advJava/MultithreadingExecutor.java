import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankAccount {
    private double balance = 500.0;

    public void deposit(double amount) {
        synchronized (this) {
            System.out.println("Depositing: " + amount);
            balance += amount;
            System.out.println("New Balance: " + balance);
        }

    }

    public void withdraw(double amount) {
        synchronized (this) {
            if (amount <= balance) {
                System.out.println("Withdrawing: " + amount);
                balance -= amount;
                System.out.println("New Balance: " + balance);
            } else {
                System.out.println("Insufficient funds for withdrawal of: " + amount);
            }

        }

    }

    public double getBalance() {
        return balance;
    }

}

public class MultithreadingExecutor {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                bankAccount.deposit(100.0);
                bankAccount.withdraw(250.0);
            });
        }
        executorService.shutdown();

    }

}


// Real Life	    Java Code
// Taxi Stand	    ExecutorService
// Taxis	        Worker threads in a pool
// Customers	    Tasks (Runnable/Callable)
// Ride	            Task execution
// Waiting queue	Task queue inside Executor
// End of the day	executor.shutdown()

// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class TaxiStandExample {
//     public static void main(String[] args) {
//         ExecutorService taxiStand = Executors.newFixedThreadPool(3); // 3 taxis

//         // 6 customers
//         for (int i = 1; i <= 6; i++) {
//             final int customerId = i;
//             taxiStand.submit(() -> {
//                 System.out.println("🚕 Taxi started ride for customer " + customerId);
//                 try {
//                     Thread.sleep(2000); // Simulating ride time
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//                 System.out.println("✅ Taxi finished ride for customer " + customerId);
//             });
//         }

//         taxiStand.shutdown(); // No more customers accepted
//     }
// }
