import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CsvToDatabase {

    private static final String DB_URL_STRING = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String CSV_FILE_PATH = "input-folder/file.csv";
    private static final int BATCH_SIZE = 3;
    private static final String INSERT_SQL = "INSERT INTO users (id,name, email,phone) VALUES (?,?, ?, ?)";

    public static void main(String[] args){
        try (
        Connection connection = DriverManager.getConnection(DB_URL_STRING,USER,PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
        BufferedReader reader = new BufferedReader (new FileReader(CSV_FILE_PATH));
        ){
            String header = reader.readLine(); // Skip header line
            System.out.println("Header: " + header);
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 4) continue; // Skip malformed lines
                preparedStatement.setInt(1, Integer.parseInt(values[0].trim()));
                preparedStatement.setString(2,values[1].trim());
                preparedStatement.setString(3, values[2].trim());
                preparedStatement.setString(4, values[3].trim());
                preparedStatement.addBatch();
                count++;
                // Execute batch every BATCH_SIZE records
                if (count == BATCH_SIZE) {
                    preparedStatement.executeBatch();
                    count =0;
                    System.out.println("Inserted " + BATCH_SIZE + " records.");
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();    
        
    }
        System.out.println("CSV file has been successfully imported into the database.");
    
}

}
