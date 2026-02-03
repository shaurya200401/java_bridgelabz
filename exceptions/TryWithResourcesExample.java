package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Program 5: try-with-resources (Auto-closing Resources)
 * 
 * Problem Statement:
 * Write a Java program that reads the first line of a file named "info.txt"
 * using BufferedReader.
 * Use try-with-resources to ensure the file is automatically closed after
 * reading.
 */
public class TryWithResourcesExample {
    public static void main(String[] args) {
        String fileName = "info.txt";

        // try-with-resources statement ensures that the resource is closed
        // automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            System.out.println("First line of the file: " + firstLine);
        } catch (IOException e) {
            // Handle exception if file is missing or unreadable
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
