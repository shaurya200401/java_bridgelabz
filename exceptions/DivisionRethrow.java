package exceptions;

import java.util.Scanner;

/**
 * Program 12: Rethrowing Exceptions
 * 
 * Problem Statement:
 * 1. Define performDivision(int numerator, int denominator) that throws
 * ArithmeticException.
 * 2. Define calculate(int numerator, int denominator) that catches and rethrows
 * it with context.
 * 3. Main handles the rethrown exception.
 */
public class DivisionRethrow {

    // Helper method to perform division
    public static int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero in performDivision.");
        }
        return numerator / denominator;
    }

    // Method that rethrows the exception with more context
    public static void calculate(int numerator, int denominator) {
        try {
            int result = performDivision(numerator, denominator);
            System.out.println("Calculation Result: " + result);
        } catch (ArithmeticException e) {
            // Rethrowing with additional context
            System.out.println("Log: Error occurred in calculation module.");
            throw new ArithmeticException("Calculation failed due to: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int den = scanner.nextInt();

            calculate(num, den);

        } catch (ArithmeticException e) {
            System.out.println("Main Caught Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid Input.");
        } finally {
            scanner.close();
        }
    }
}
