package advJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultiprocessingExample {

	
	public static void main(String[] args) {
		
		try {
			
			// Create a new process to run a simple command
			ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c","echo Hello from Process!");
			Process process = processBuilder.start();
			
			//Read output from the process
			BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(process.getInputStream()));
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println("line : "+line);
			}
			
			int exitCode= process.waitFor();
			
			System.out.println("exitCode : "+exitCode);
			
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
