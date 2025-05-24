package advJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

//A short-cut for writing implementations of functional interfaces.
//A lambda expression lets you create an instance of a functional interface 
//in a clean, concise way, using this syntax: (parameter) -> { body }
public class LambdaExpressionsEg {
	public static void main(String[] args) {
		
	//Example 1: Sorting a List with Lambda
	//Instead of writing a full Comparator class, we use a lambda to define sorting logic.
	List<String> names = Arrays.asList("John", "Alice", "Bob");
	Collections.sort(names, (a,b) -> a.compareTo(b));
	System.out.println(names); // [Alice, Bob, John]
	
	//Example 2: Filtering with Streams
	//Here, name -> name.startsWith("A") is the lambda that checks the condition.
	List<String> names2 = Arrays.asList("Anna", "Alex", "Brian");
	names2.stream()
	     .filter(name -> name.startsWith("A"))
	     .forEach(System.out::println);  // Anna, Alex
	
	//Example 3: Runnable with Lambda
	//Instead of creating a class that implements Runnable, we use a lambda to define run().
	Runnable r = () -> System.out.println("Thread running...");
	new Thread(r).start();
	
	
	//Example 4: Custom Functional Interface
	//We define our own interface and implement it using lambda expressions.
    MathOperation add = (a, b) -> a + b;
    MathOperation multiply = (a, b) -> a * b;
    System.out.println(add.operate(5, 3));       // 8
    System.out.println(multiply.operate(5, 3));  // 15

    //Example 5: Using Predicate (from java.util.function)
    //Predicate is a built-in functional interface with a test() method. Lambdas can implement it easily.
    Predicate<String> isLong = s -> s.length() > 5;
    System.out.println(isLong.test("Hello"));     // false
    System.out.println(isLong.test("Elephant"));  // true
    
    //Example 6: Using Consumer
    //Consumer is a functional interface that takes one input and returns nothing (void).
    Consumer<String> greet = name -> System.out.println("Hello, " + name);
    greet.accept("Sam");  // Output: Hello, Sam
    
    //Example 7: Map Iteration with Lambda
    //We pass a lambda to forEach() that defines what to do with each key-value pair.
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "One");
    map.put(2, "Two");
    map.forEach((key, value) -> System.out.println(key + ": " + value));



	
	}
	
}
