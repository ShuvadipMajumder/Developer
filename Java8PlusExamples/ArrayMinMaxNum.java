public class ArrayMinMaxNum {

    public static void main(String[] args) {
        int[] numbers = { 3, 5, 1, 8, 2 };
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        // Java 8 style min and max
        int minJava8 = java.util.Arrays.stream(numbers).min().orElseThrow();
        int maxJava8 = java.util.Arrays.stream(numbers).max().orElseThrow();
        System.out.println("Minimum Java 8: " + minJava8);
        System.out.println("Maximum Java 8: " + maxJava8);

    }
}
