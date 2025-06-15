import java.util.function.Function;
// This program demonstrates method references in Java.
// It defines a static method and an instance method that calculate the square of a number.
// It then uses method references to create Function objects that refer to these methods.
// The static method reference is used to refer to a static method in a class,
// while the instance method reference is used to refer to a non-static method in an instance of a class.

class StaticMethodRef {
	public static double square(double num) {
		System.out.println("inside StaticMethodRef class");
		return Math.pow(num, 2);
	}
}

class RegularMethodRef {
	public double square(double num) {
		System.out.println("inside RegularMethodRef class");
		return Math.pow(num, 2);
	}
}

public class MethodReference {
	public static void main(String[] args) {

		Function<Double, Double> square = StaticMethodRef::square;
		double ansStatic = square.apply(23d);
		System.out.println("ansStatic : " + ansStatic);

		RegularMethodRef hey = new RegularMethodRef();
		Function<Double, Double> square2 = hey::square;
		double ansInstance = square2.apply(23d);
		System.out.println("ansInstance : " + ansInstance);
	}
}