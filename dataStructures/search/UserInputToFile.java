package DataStructures.Search;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to read user input and write to file using InputStreamReader.
 */
public class UserInputToFile {

    public static void main(String[] args) {
        String dataFile = "user_input.txt";

        System.out.println("Enter text to write to file. Type 'exit' to finish.");

        try (
                // Create InputStreamReader to read from System.in
                InputStreamReader isr = new InputStreamReader(System.in);
                // Wrap in BufferedReader
                BufferedReader br = new BufferedReader(isr);
                // Create FileWriter
                FileWriter fw = new FileWriter(dataFile)) {
            String line;
            while (true) {
                System.out.print("> ");
                line = br.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(line + System.lineSeparator());
            }
            System.out.println("Data written to " + dataFile);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
