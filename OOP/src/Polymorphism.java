// Polymorphism: The ability of an object to take many forms. It allows a method to behave differently based on the object calling it.

class DomAnimal {
	void sound() {
		System.out.println("Animal makes a sound");
	}
}

class Cow extends DomAnimal {
	@Override
	void sound() {
		System.out.println("Cow moos");
	}
}

class Cat extends DomAnimal {
	@Override
	void sound() {
		System.out.println("Cat meows");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		DomAnimal myAnimal = new DomAnimal();
		DomAnimal myCow = new Cow();
		DomAnimal myCat = new Cat();

		myAnimal.sound(); // Animal makes a sound
		myCow.sound(); // Cow moos
		myCat.sound(); // Cat meows
	}
}


//Real-life example: Payment Methods
//
//A payment system allows different ways of paying, such as credit cards, digital wallets, or cash. Each payment method has a different implementation for processing payments, but they all share a common interface, like pay(). The system can process any kind of payment in the same way, despite each one being different.
//
//Common interface: PaymentMethod with a pay() method.
//Different implementations: CreditCardPayment, WalletPayment, CashPayment, etc.