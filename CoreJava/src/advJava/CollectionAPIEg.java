

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Java 8 enhanced interfaces like List, Map, and Set with default methods.
//A default method is a method defined inside an interface with the keyword default. 
//It provides a default implementation, so classes that implement the interface 
//don’t need to implement it unless they want to override it.
public class CollectionAPIEg {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("A", "B", "C");
		list.forEach(item -> System.out.println(item));
		list.removeIf(item -> item.equals("B")); // Output: [A, C]
		list.replaceAll(String::toLowerCase); // Output: [a, b, c]
		
		Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4));
		numbers.removeIf(n -> n % 2 == 0);
		// Output: [1, 3]

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.forEach((key, value) -> System.out.println(key + " = " + value));
		System.out.println(map.getOrDefault(3, "Not Found")); // Output: Not Found
		map.putIfAbsent(2, "TwoAgain"); // Won't overwrite existing key
		map.computeIfAbsent(3, key -> "Three");
		System.out.println(map); // {1=One, 2=Two, 3=Three}
		map.merge(1, "New", (oldVal, newVal) -> oldVal + "-" + newVal);
		// {1=One-New, 2=Two, 3=Three}

	}

}
