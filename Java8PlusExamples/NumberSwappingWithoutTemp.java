public class NumberSwappingWithoutTemp {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        // Swapping without using a temporary variable
        a = a + b; // Step 1: Add both numbers
        b = a - b; // Step 2: Subtract the new value of 'a' by 'b' to get original 'a'
        a = a - b; // Step 3: Subtract the new value of 'b' from 'a' to get original 'b'

        System.out.println("After swapping: a = " + a + ", b = " + b);
        //Java 8 doesn't offer a built-in feature to simplify number swapping
    }

}
