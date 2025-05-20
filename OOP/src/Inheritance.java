//Inheritance: A class can inherit fields and methods from another class.

class Animal {
	protected String color ="blue";
	void sound() {
		System.out.println("Animal makes a sound");
	}
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("Dog barks");
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound(); // Calls Dog's version of sound()
		System.out.println(dog.color);
	}
}


//Real-life example: Animal Kingdom
//
//In the animal kingdom, there are different types of animals like birds, fish, and mammals, but they all share some common traits. For example, they all have a way of moving, but each animal moves differently. Using inheritance, you can define a general Animal class with common features and then extend that class to create specialized classes for Bird, Fish, etc.
//
//Superclass: Animal (common behavior like eat(), sleep()).
//Subclass: Bird, Fish, etc., which inherit the behavior but may add their specific actions (e.g., fly() for birds).