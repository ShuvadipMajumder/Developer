class StaticMethodRef {
     public static double square(double num){
        return Math.pow(num, 2);
    }
}


class RegularMethodRef {
    public double square(double num) {
        return Math.pow(num, 2);
    }
}



public class MethodReference {
	public static void main(String[] args) {

Function<Double, Double> square = StaticMethodRef::square;
double ansStatic = square.apply(23d);


RegularMethodRef hey = new RegularMethodRef();
Function<Double, Double> square = hey::square;
double ansInstance = square.apply(23d);


}