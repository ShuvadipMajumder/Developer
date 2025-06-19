package singleton;

public class AppConfig {
    private static AppConfig instance;

    private AppConfig() {
        System.out.println("Config loaded...");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public void printConfig() {
        System.out.println("AppConfig: Production");
    }
}

