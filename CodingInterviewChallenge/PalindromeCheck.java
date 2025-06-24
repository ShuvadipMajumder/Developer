
public class PalindromeCheck {

	private static boolean isPalindrome(String str) {

		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		String str1 = "Interview";
		String str2 = "Racecar";
		System.out.println("Interview is Palindrome : " + isPalindrome(str1.toLowerCase()));
		System.out.println("Racecar is Palindrome : " + isPalindrome(str2.toLowerCase()));
	}

}
