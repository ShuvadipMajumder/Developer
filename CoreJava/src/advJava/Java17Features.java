package advJava;

import java.util.*;

public class Java17Features {
	
    // Sealed class demo
    sealed interface Shape permits Circle, Square {
        void draw();
    }

    static final class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    static final class Square implements Shape {
        public void draw() {
            System.out.println("Drawing Square");
        }
    }

    // Record class demo
    // Fields in a record class are inherently final, meaning their values cannot be altered once the record is created
    // Use case: data transfer objects (DTOs), database entities, or other similar data-carrying roles
    record Person(String name, int age) {}
    
    public static void main(String[] args) {

        // 1. Pattern matching with instanceof - No need to cast manually
        Object obj = "Java";
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }

        // 2. Sealed classes - Control inheritance hierarchy
        Shape shape = new Circle();
        shape.draw();

        // 3. Switch expression - More concise and powerful switch
        String day = "FRIDAY";
        String result = switch (day) {
            case "MONDAY", "TUESDAY" -> "Workday";
            case "FRIDAY" -> "Almost weekend!";
            default -> "Midweek";
        };
        System.out.println(result);

        // 4. Text blocks - Multiline strings with clean syntax
        String html = """
                <html>
                    <body>
                        <h1>Hello</h1>
                    </body>
                </html>
                """;
        System.out.println(html);

        // 5. Record class - Immutable data class with constructor, getters, equals, hashCode
        // Fields in a record class are inherently final, meaning their values cannot be altered once the record is created
        // Use case: data transfer objects (DTOs), database entities, or other similar data-carrying roles
        Person person = new Person("Alice", 30);
        System.out.println(person.name());

        // 6. Compact number formatting (via ICU in other APIs)
        System.out.printf("Formatted: %,d%n", 1000000); // Output: 1,000,000

        // 7. Helpful NullPointerException messages - JVM shows variable name that was null
        try {
            String str = null;
            str.length(); // triggers helpful NPE
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: " + e.getMessage());
        }

        // 8. Enhanced pseudo-random number generators
        var generator = java.util.random.RandomGenerator.of("L64X256MixRandom");
        System.out.println("Random: " + generator.nextInt(100));

        // 9. Unicode 13 support - Emoji and character updates
        String emoji = "🥳";
        System.out.println("Emoji: " + emoji);

        // 10. Strong encapsulation of JDK internals (JEP 403) - No reflective access by default
        System.out.println("JDK internals strongly encapsulated - use modules to allow reflective access");
    }


}

