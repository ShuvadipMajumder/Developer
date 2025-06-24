
//Count Words Using HashMap

import java.util.HashMap;

public class WordCount {

	public static void main(String[] args) {
		String input = "Hi Hello Hello Java Hello World Hello Java World";
		String[] words = input.split(" ");
		HashMap<String, Integer> map = new HashMap<>();

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		System.out.println("Map: " + map);

	}

}
