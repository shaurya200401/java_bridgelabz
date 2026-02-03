package exceptions;

import java.util.Scanner;

/**
 * Program 10: Bank Transaction System (Checked + Custom Exception)
 * 
 * Problem Statement:
 * Develop a Bank Account System where:
 * withdraw(double amount) method:
 * Throws InsufficientBalanceException if withdrawal amount exceeds balance.
 * Throws IllegalArgumentException if the amount is negative.
 * Handle exceptions in main().
 */

// Custom Checked Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankTransactionSystem {
    private double balance = 1000.00; // Initial balance

    // Method to withdraw amount
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount! Amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Current balance: " + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        BankTransactionSystem bank = new BankTransactionSystem();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Current Balance: " + bank.balance);
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            // Attempt withdrawal
            bank.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            // Handle custom checked exception
            System.out.println("Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handle unchecked exception
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
