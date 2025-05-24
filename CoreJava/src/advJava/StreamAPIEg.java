package advJava;

import java.util.Arrays;
import java.util.List;

//A new way to process collections like filtering, mapping, and sorting declaratively.
public class StreamAPIEg {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");

		names
		.stream()
		.filter(name -> name.startsWith("C"))
		.forEach(System.out::println); // Output: Charlie

		names
		.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println); // Output: [JOHN, ALICE, BOB, CHARLIE]

		names
		.stream()
		.sorted()
		.forEach(System.out::println); // Output: [Alice, Bob, Charlie, John]

	}

}
