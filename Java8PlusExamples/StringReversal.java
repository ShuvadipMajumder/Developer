import java.util.stream.Collectors;

public class StringReversal {

    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static String reverseJava8(String input) {
        String reversed = input.chars()                      // Convert to IntStream
                .mapToObj(c -> (char) c)                        // Convert to Character stream
                .collect(Collectors.collectingAndThen(          // Collect in reverse order
                        Collectors.toList(),
                        list -> {
                            java.util.Collections.reverse(list);
                            return list.stream()
                                       .map(String::valueOf)
                                       .collect(Collectors.joining());
                        }));
        return reversed;

    }

    public static void main(String[] args) {
        String original = "Hello, World!";
        String reversed = reverse(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        String originalJava8 = "Hello, World Java 8!";
        String reversedJava8 = reverseJava8(original);
        System.out.println("originalJava8: " + originalJava8);
        System.out.println("reversedJava8: " + reversedJava8);
    }    

}
