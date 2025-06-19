package advJava;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Optional;

@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}

interface Vehicle {
    default void start() {
        System.out.println("Vehicle started");
    }
    static void stop() {
        System.out.println("Vehicle stopped");
    }
}

public class Java8Features {
	
    static class MyVehicle implements Vehicle {}
    
    public static void main(String[] args) {

        // 1. Lambda Expression - Short way to write anonymous methods
        Runnable r = () -> System.out.println("Hello from Lambda!");
        r.run();
        List<Integer> intList = Arrays.asList(5,2,7,4,9,1);
        Collections.sort(intList, (a,b)->a.compareTo(b));
        System.out.println("Sorted : "+intList);

        // 2. Functional Interface - Interface with single abstract method
        Calculator multiply = (a,b) -> a*b;
        Calculator add = (a, b) -> a + b;
        System.out.println("Sum: " + add.compute(5, 3));
        System.out.println("Multiply: " + multiply.compute(5, 3));

        // 3. Stream API - Functional operations on collections
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        List<String> filtered = names.stream()
            .filter(n -> n.startsWith("A"))
            .collect(Collectors.toList());
        List<String> sorted = names.stream().sorted().collect(Collectors.toList());
        List<String> mapped = names.stream().map(n->n.toUpperCase()).collect(Collectors.toList());
        System.out.println("filtered: " +filtered);
        System.out.println("sorted : "+sorted);
        System.out.println("mapped : "+mapped);

        // 4. Default method in interface - Add method to interface without breaking implementers
        new MyVehicle().start();

        // 5. Static method in interface - Utility method inside interface
        Vehicle.stop();

        // 6. Optional - Avoid NullPointerException
        Optional<String> nameOpt = Optional.ofNullable("java");
        nameOpt.ifPresent(n -> System.out.println("Optional output: " + n.toUpperCase()));

        // 7. Method Reference - Shorter way of writing lambda for existing methods
        names.forEach(System.out::println);

        // 8. Collectors - Terminal operation to collect stream results
        String result = names.stream().collect(Collectors.joining(", "));
        System.out.println(result);

        // 9. Predicate - Functional interface used for conditions
        //Predicate<T> takes an input argument of type T and returns a boolean value
        names.stream().filter(((String s) -> s.length() > 3)).forEach(System.out::println);

        // 10. Function - Functional interface for transforming data
        //Function<T, R> takes two type parameters:	T: type of the input argument. 	R: type of the result produced by the function.
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Length of 'Java': " + strLength.apply("Java"));
    }

}

