import java.util.Arrays;

//The Fibonacci sequence is a sequence where the next term is the sum of the previous two terms. 
//The first two terms of the Fibonacci sequence are 0 followed by 1. 
//The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21
//Base case: F(n) = n, when n = 0 or n = 1
//Recursive case: F(n) = F(n-1) + F(n-2) for n>1
public class FibonacciUsingMemoization {
	// Function to calculate the nth Fibonacci number using memoization
    static int nthFibonacciUtil(int n, int[] memo) {
      
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }

        // Check if the result is already in the memo table
        if (memo[n] != -1) {
            return memo[n];
        }

        // Recursive case: calculate Fibonacci number
        // and store it in memo
        memo[n] = nthFibonacciUtil(n - 1, memo) 
                       + nthFibonacciUtil(n - 2, memo);

        return memo[n];
    }

    // Wrapper function that handles both initialization
    // and Fibonacci calculation
    static int nthFibonacci(int n) {

        // Create a memoization table and initialize with -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        
        // Call the utility function
        return nthFibonacciUtil(n, memo);
    }

    public static void main(String[] args) {
        int n = 7;
        int result = nthFibonacci(n);
        System.out.println(result);
    }
}
