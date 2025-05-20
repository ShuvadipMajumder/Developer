package design.prototype;

//Prototype interface
interface Shape {
	Shape clone();
	void draw();
}

//Concrete prototype class
class Circle implements Shape {
	private String color;

	public Circle(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public Shape clone() {
		//return new Circle(this.color); //Deep clone
		return this; // Shallow clone
	}

	@Override
	public void draw() {
		System.out.println("Drawing a " + color + " circle");
	}
}

//Client
public class PrototypePatternDemo {
	public static void main(String[] args) {
		Circle blueCircle = new Circle("Blue");
		Circle clonedCircle = (Circle) blueCircle.clone();

		blueCircle.draw(); // Output: Drawing a Blue circle
		clonedCircle.draw(); // Output: Drawing a Blue circle
		clonedCircle.setColor("DeepBlue");
		blueCircle.draw();
		clonedCircle.draw();
		
	}
}
