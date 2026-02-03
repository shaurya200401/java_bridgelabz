package exceptions;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Program 2: Unchecked Exception (Runtime Exception)
 * 
 * Problem Statement:
 * Write a Java program that asks the user to enter two numbers and divides
 * them.
 * Handle ArithmeticException (division by zero) and InputMismatchException.
 */
public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for input
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            // Handle non-numeric input
            System.out.println("Error: Invalid input. Please enter integers.");
        } finally {
            scanner.close(); // Close scanner
        }
    }
}
