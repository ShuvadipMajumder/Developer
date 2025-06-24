
// Check If All Numbers in List Are Odd or Even

import java.util.Arrays;
import java.util.List;

public class AllOddEvenCheck {

	public static void main(String[] args) {
		List<Integer> num1 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> num2 = Arrays.asList(2, 4, 6, 8, 10);

		boolean allOdd = num1.stream().allMatch(n -> n % 2 != 0);
		boolean allEven = num2.stream().allMatch(n -> n % 2 == 0);

		System.out.println("allOdd : " + allOdd);
		System.out.println("allEven : " + allEven);

	}

}
