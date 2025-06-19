package advJava;

import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.nio.file.*;
import java.util.List;

public class Java11Features {
    public static void main(String[] args) throws Exception {

        // 1. var in lambda parameters - Allows type inference in lambdas
        List<String> list = List.of("Java", "Python");
        list.forEach((var item) -> System.out.println("Language: " + item));

        // 2. isBlank() - Checks if string is empty or whitespace
        System.out.println(" ".isBlank()); // true

        // 3. strip() - Removes leading and trailing whitespaces
        System.out.println(" Java ".strip()); // "Java"

        // 4. lines() - Splits string into stream of lines
        System.out.println("A\nB\nC".lines().count()); // 3

        // 5. repeat(n) - Repeats a string n times
        System.out.println("Hi ".repeat(3)); // Hi Hi Hi 

        // 6. Files.writeString() - Write a string to a file
        Path path = Paths.get("C:/Workspace/Developer/CoreJava/src/advJava", "file.txt");
        Files.writeString(path, "Hello Java 11!");

        // 7. Files.readString() - Read file content as string
        String content = Files.readString(path);
        System.out.println(content);

        // 8. Collection.of() - Create immutable lists, sets, maps
        List<String> fruits = List.of("Apple", "Banana", "Mango");
        System.out.println(fruits);

        // 9. HttpClient API - Modern HTTP client for REST calls
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("https://httpbin.org/get"))
//            .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.statusCode());

        // 10. Optional.isEmpty() - Opposite of isPresent()
        var optional = java.util.Optional.empty();
        System.out.println(optional.isEmpty()); // true
    }
}

