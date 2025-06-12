import java.util.Optional;

public class OptionalEg {
	
	//Optional is a container that may or may not contain a value. Helps prevent NullPointerException.
	public static void main(String[] args) {
		
		Optional<String> gift = Optional.ofNullable(null);
		System.out.println(gift.orElse("No gift"));
	}

}
