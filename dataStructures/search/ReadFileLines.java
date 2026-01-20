package DataStructures.Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to read a file line by line using FileReader.
 */
public class ReadFileLines {

    // Method to read file line by line
    public static void readFile(String filePath) {
        // Create a FileReader object using try-with-resources for auto-close
        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {

            String line;
            // Use a loop to read each line using the readLine() method
            while ((line = br.readLine()) != null) {
                // Print it to the console
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Make sure this file exists or provide absolute path
        System.out.println("Reading file: " + filePath);

        // Creating a dummy file for demonstration if it doesn't exist
        createDummyFile(filePath);

        readFile(filePath);
    }

    private static void createDummyFile(String filePath) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            fw.write("Line 1: Hello World\n");
            fw.write("Line 2: Java File I/O\n");
            fw.write("Line 3: BufferedReader usage\n");
        } catch (IOException e) {
            System.err.println("Could not create dummy file: " + e.getMessage());
        }
    }
}
