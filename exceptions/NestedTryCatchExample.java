package exceptions;

import java.util.Scanner;

/**
 * Program 9: Nested try-catch Block
 * 
 * Problem Statement:
 * Write a Java program that uses nested try-catch to handle:
 * ArrayIndexOutOfBoundsException if the index is invalid.
 * ArithmeticException if the divisor is zero.
 */
public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define a divisor array for demonstration
        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.print("Enter index to access (0-4): ");
        int index = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        // Outer try block
        try {
            // Try to access the array element
            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);

            // Inner try block for division
            try {
                int result = value / divisor;
                System.out.println("Division Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
