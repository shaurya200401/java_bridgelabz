package exceptions;

/**
 * Program 15: Rethrowing Exceptions with Custom Context
 * 
 * Problem Statement:
 * Catches and rethrows a custom exception with additional context about the
 * transaction.
 */

// Custom Exception for Transaction Failure
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class TransactionProcessor {

    // Method simulates low-level processing that may fail
    public void processPayment(double amount) throws TransactionException {
        if (amount > 5000) {
            // Simulate a failure for large amounts
            throw new TransactionException("Payment gateway rejected validation for amount: " + amount);
        }
        System.out.println("Payment processed: $" + amount);
    }

    // High-level method that adds context
    public void handleTransaction(String userId, double amount) throws TransactionException {
        try {
            System.out.println("Initiating transaction for user: " + userId);
            processPayment(amount);
        } catch (TransactionException e) {
            // Rethrowing with additional context (User ID)
            System.out.println("Log: Transaction failed at low level. Adding context.");
            throw new TransactionException("Transaction failed for UserID: " + userId + ". Reason: " + e.getMessage(),
                    e);
        }
    }

    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();

        // Scenario 1: Successful
        try {
            processor.handleTransaction("USER_001", 2000);
        } catch (TransactionException e) {
            System.out.println("Main Caught: " + e.getMessage());
        }

        System.out.println("---");

        // Scenario 2: Failure and Rethrow
        try {
            processor.handleTransaction("USER_999", 10000);
        } catch (TransactionException e) {
            System.out.println("Main Caught: " + e.getMessage());
            // Can inspect cause
            // System.out.println("Original Cause: " + e.getCause().getMessage());
        }
    }
}
