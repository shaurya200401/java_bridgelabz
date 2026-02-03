package exceptions;

import java.util.Scanner;

/**
 * Program 6: throw vs. throws (Exception Propagation)
 * 
 * Problem Statement:
 * Create a method calculateInterest(double amount, double rate, int years)
 * that:
 * Throws IllegalArgumentException if amount or rate is negative.
 * Propagates the exception using throws and handles it in main().
 */
public class ExceptionPropagationExample {

    // Method using 'throws' to declare that it might throw an exception
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Using 'throw' to manually throw an exception
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Principal Amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter Interest Rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter Years: ");
            int years = scanner.nextInt();

            // Call method that may throw exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            // Handle the propagated exception
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
