public class FizzBuzz {

    /**
     * Prints numbers from 0 to 100, replacing multiples of 3 with "Fizz",
     * multiples of 5 with "Buzz", and multiples of both with "FizzBuzz".
     */
    public static void main(String[] args) {
        var maxInt = 100;
        for (int i = 0; i < maxInt; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

}
