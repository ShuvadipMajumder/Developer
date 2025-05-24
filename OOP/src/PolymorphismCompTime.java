//Compile-Time Polymorphism (Method Overloading)
//This happens during compilation. It’s mainly achieved through method overloading—when multiple methods have the same name but different parameters (number or type).
public class PolymorphismCompTime {

	// Method with 2 int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method with 3 int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static void main(String[] args) {
    	PolymorphismCompTime calc = new PolymorphismCompTime();
    	System.out.println(calc.add(2, 3));      // Output: 5
    	System.out.println(calc.add(1, 2, 3));   // Output: 6
    }
}


//Real-Life Example:
//Think of a printer that prints:
//A photo (using print(Image image))
//A document (using print(Document doc))
//A text file (using print(String text))
//The action (printing) is the same, but the input differs.
