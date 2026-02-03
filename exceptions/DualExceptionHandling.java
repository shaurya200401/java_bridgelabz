package exceptions;

import java.io.FileNotFoundException;

/**
 * Program 16: Throwing and Handling Checked and Unchecked Exceptions
 * 
 * Problem Statement:
 * Create a method that processes data and throws both checked and unchecked
 * exceptions.
 * Handle both types of exceptions in the main method.
 */
public class DualExceptionHandling {

    // Method that throws both Checked (FileNotFoundException) and Unchecked
    // (IllegalArgumentException)
    public static void processData(String fileName, int dataValue) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty()) {
            // Unchecked Exception
            throw new IllegalArgumentException("File name cannot be empty.");
        }

        if (fileName.equals("missing.txt")) {
            // Checked Exception
            throw new FileNotFoundException("File not found: " + fileName);
        }

        System.out.println("Processing data " + dataValue + " from file " + fileName);
    }

    public static void main(String[] args) {
        System.out.println("Processing starts...");

        // Case 1: Handle Unchecked Exception
        try {
            processData("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Unchecked: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked: " + e.getMessage());
        }

        // Case 2: Handle Checked Exception
        try {
            processData("missing.txt", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Unchecked: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked: " + e.getMessage());
        }

        // Case 3: Proper Execution
        try {
            processData("valid.txt", 200);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
