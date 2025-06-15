//Abstraction: Hiding the complex implementation details and showing only the essential features of an object via interface.
abstract class Shape {
	abstract void draw(); // Abstract method (no implementation)
}

class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("Drawing a Circle");
	}
}

class Rectangle extends Shape {
	@Override
	void draw() {
		System.out.println("Drawing a Rectangle");
	}
}

public class Abstraction {
	public static void main(String[] args) {
		Shape shape1 = new Circle();
		Shape shape2 = new Rectangle();

		shape1.draw(); // Drawing a Circle
		shape2.draw(); // Drawing a Rectangle
	}
}

// Real-life example: Car Driving
//
// When you drive a car, you don't need to know the intricate details of how the
// engine works or how the car processes fuel.
// All you need to do is press the accelerator to go forward, press the brake to
// stop, and turn the steering wheel to change direction. The complex
// implementation of the car's mechanics is hidden from the user.
// Abstract class: Car with abstract methods like start(), stop(), accelerate().
// Concrete classes: ElectricCar, GasCar, which implement the abstract methods.