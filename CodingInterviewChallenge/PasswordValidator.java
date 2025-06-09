import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your password to validate : ");
		String pass = scanner.nextLine();
		if (isPasswordValid(pass)) {
			System.out.println("Valid Password");
		} else {
			System.out.println("Invalid Password");
		}
	}

	private static boolean isPasswordValid(String pass) {
		// Regex Explanation:
        // ^                         → start of the string
        // (?=.*[0-9])               → at least one digit
        // (?=.*[a-z])               → at least one lowercase letter
        // (?=.*[A-Z])               → at least one uppercase letter
        // (?=.*[@#$%^&+=!])         → at least one special character
        // (?=\\S+$)                 → no whitespace
        // .{8,}                     → at least 8 characters
        // $                         → end of the string
		
		String regex = "^(?=.*[0-9])" + 
		                "(?=.*[a-z])" +
		                "(?=.*[A-Z])" +
		                "(?=.*[@#$%^&+=!])" +
		                "(?=\\S+$).{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pass);
						
		return matcher.matches();
	}

}
