package exceptions;

import java.util.Scanner;

/**
 * Program 3: Custom Exception (User-defined Exception)
 * 
 * Problem Statement:
 * Create a custom exception called InvalidAgeException.
 * Write a method validateAge(int age) that throws InvalidAgeException if the
 * age is below 18.
 */

// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw custom exception if age is invalid
            throw new InvalidAgeException("Age must be 18 or above.");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = scanner.nextInt();
            // Call validation method
            validateAge(age);
        } catch (InvalidAgeException e) {
            // Catch custom exception
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            // General exception for input mismatch etc.
            System.out.println("Invalid Input.");
        } finally {
            scanner.close();
        }
    }
}
