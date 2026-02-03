package exceptions;

import java.util.Scanner;

/**
 * Program 7: finally Block Execution
 * 
 * Problem Statement:
 * Write a program that performs integer division and demonstrates the finally
 * block execution.
 * The program should ensure "Operation completed" is always printed using
 * finally.
 */
public class FinallyBlockExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second integer: ");
            int num2 = scanner.nextInt();

            // May throw ArithmeticException
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: Cannot divide by zero.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // This block executes regardless of exception occurrence
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
