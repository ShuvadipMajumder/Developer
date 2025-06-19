package observer;
public class Subscriber {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String video) {
        System.out.println(name + " received video notification: " + video);
    }
}