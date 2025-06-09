import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PhoneNumberRedactor {

    public static final String REDACTED_STRING = "PH NO REDACTED";
    public static final String PHONE_NUMBER_REGEX = "\\b\\d{3}[\\s.-]\\d{3}[\\s.-]\\d{4}\\b";

    public static void redactPhoneInFile(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        String redactedContent = content.replaceAll(PHONE_NUMBER_REGEX, REDACTED_STRING);
        Files.writeString(Path.of(filePath), redactedContent);
    }

    public static void main(String[] args) {
        String folderPath = "input-folder";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        for (File file : files) {
            try {
                redactPhoneInFile(file.getAbsolutePath());
                System.err.println("File: " + file.getName() + " processed successfully");
            
            } catch (IOException e) {
                System.err.println("Error processing file: " + file.getName() + " - " + e.getMessage());
            }
            ;
        }
    }

}
