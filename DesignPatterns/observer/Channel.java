package observer;
import java.util.ArrayList;
import java.util.List;

public class Channel {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
    }

    public void uploadVideo(String title) {
        System.out.println("Uploaded: " + title);
        for (Subscriber sub : subscribers) {
            sub.update(title);
        }
    }
}