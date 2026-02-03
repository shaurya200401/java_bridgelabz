package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Program 1: Checked Exception (Compile-time Exception)
 * 
 * Problem Statement:
 * Create a Java program that reads a file named "data.txt".
 * If the file does not exist, handle the IOException properly and display a
 * user-friendly message.
 */
public class FileReadExample {
    public static void main(String[] args) {
        // Define the file name
        String fileName = "data.txt";

        System.out.println("Attempting to read file: " + fileName);

        // Try to read the file
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            System.out.println("File contents:");

            // Read line by line until end of file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            bufferedReader.close();
        } catch (IOException e) {
            // Handle the exception if file is not found or cannot be read
            System.out.println("File not found or could not be read. (" + e.getMessage() + ")");
        }
    }
}
