//Encapsulation: Wrapping the data and methods to protect them from unauthorized access.
//Hiding the internal details of an object and providing access to the data via getter and setter methods.
class Person {
	private String name; // Private variable

	// Getter method
	public String getName() {
		return name;
	}

	// Setter method
	public void setName(String name) {
		this.name = name;
	}
}

public class Encapsulation {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Alice"); // Setting value using setter
		System.out.println(person.getName()); // Accessing value using getter
	}
}


//Real-life example: Bank Account
//
//In real life, a bank account has private details such as the account balance, which shouldn't be directly accessible to anyone for security reasons. Instead, we provide controlled access to it through methods like deposit, withdraw, or check balance.
//
//Private data: Account balance is hidden.
//Public methods: Methods like deposit(), withdraw(), and getBalance() provide controlled access.