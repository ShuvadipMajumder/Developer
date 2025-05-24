package advJava;

import java.util.function.Function;

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
		System.out.println("ansStatic : "+ansStatic);
		RegularMethodRef hey = new RegularMethodRef();
		Function<Double, Double> square2 = hey::square;
		double ansInstance = square2.apply(23d);
		System.out.println("ansInstance : "+ansInstance);
	}
}