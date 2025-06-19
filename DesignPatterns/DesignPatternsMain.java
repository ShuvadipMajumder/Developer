import singleton.AppConfig;
import factory.NotificationFactory;
import strategy.*;
import observer.*;
import builder.User;

public class DesignPatternsMain {
    public static void main(String[] args) {
    	
    	//Ensures a class has only one instance and provides a global point of access to it.
    	//One shared instance
        System.out.println("=== Singleton ===");
        AppConfig config1 = AppConfig.getInstance();
        config1.printConfig();

        //Creates objects without exposing the creation logic to the client and 
        //refers to the newly created object using a common interface.
        //Create object based on input
        System.out.println("\n=== Factory ===");
        var notification = NotificationFactory.createNotification("EMAIL");
        notification.notifyUser();

        //Defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime.
        //Change behavior at runtime
        System.out.println("\n=== Strategy ===");
        var service = new PaymentService();
        service.setStrategy(new CreditCardPayment());
        service.checkout(100);
        service.setStrategy(new PayPalPayment());
        service.checkout(250);

        //Defines a one-to-many dependency, so when one object changes state, 
        //all its dependents (observers) are notified automatically.
        //Notify multiple listeners of an event
        System.out.println("\n=== Observer ===");
        Channel channel = new Channel();
        Subscriber alice = new Subscriber("Alice");
        Subscriber bob = new Subscriber("Bob");
        channel.subscribe(alice);
        channel.subscribe(bob);
        channel.uploadVideo("Observer Design Pattern Explained");

        //Builds a complex object step-by-step, allowing optional parameters and fluent API style.
        //Build object with optional values, step-by-step
        System.out.println("\n=== Builder ===");
        User user = new User.Builder()
                .setName("John")
                .setAge(30)
                .setEmail("john@example.com")
                .build();
        user.printInfo();
    }
}
