import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;

public class ArrayManipulation {
    public static int[] reverse(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int[] reversed = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            reversed[i] = input[input.length - 1 - i];
        }
        return reversed;
    }

    public static int[] reverseJava8(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream().mapToInt(Integer::intValue).toArray();
                        }));
    }

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4, 5 };
        int[] reversed = reverse(original);

        System.out.print("Original: ");
        for (int num : original) {
            System.out.print(num + " ");
        }

        System.out.print("\nReversed: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }
        // Java 8 style reversal

        int[] originalJava8 = { 6, 7, 8, 9, 10 };
        int[] reversedJava8 = reverseJava8(originalJava8);

        System.out.print("\nOriginal Java 8: ");
        for (int num : originalJava8) {
            System.out.print(num + " ");
        }

        System.out.print("\nReversed Java 8: ");
        for (int num : reversedJava8) {
            System.out.print(num + " ");
        }
    }
}
