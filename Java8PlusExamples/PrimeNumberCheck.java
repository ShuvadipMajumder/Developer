
public class PrimeNumberCheck {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, it's prime
    }
    public static boolean isPrimeJava8(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        return java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0); // Check for divisors
    }

    public static void main(String[] args) {
        int[] testNumbers = {2, 3, 4, 5, 16, 17, 18, 19, 20};
        for (int num : testNumbers) {
            System.out.println(num + " is prime? " + isPrime(num));
        }
        System.out.println("Using Java 8 style:");  
        for (int num : testNumbers) {
            System.out.println(num + " is prime? " + isPrimeJava8(num));
        }   
    }

}
