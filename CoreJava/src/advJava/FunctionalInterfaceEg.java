

//An interface with only one abstract method. It can have multiple default or static methods.
@FunctionalInterface
interface Greeting {
	void sayHello();
}

public class FunctionalInterfaceEg {
	public static void main(String[] args) {
		Greeting g =() -> System.out.println("Hello!");
		g.sayHello();
	}
}

// Real-life: Like a button with one action — “onClick”.