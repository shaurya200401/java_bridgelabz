package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced Problem 1: Testing Banking Transactions
 * This class simulates a bank account with deposit, withdraw, and balance
 * check.
 * Includes JUnit tests for balance updates and insufficient funds.
 */
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Adds money to the balance
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
    }

    // Reduces balance if funds are sufficient
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }
}

public class BankingServiceTest {

    // Test deposit
    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001, "Balance should be 150.0 after deposit");
    }

    // Test withdrawal
    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), 0.001, "Balance should be 60.0 after withdrawal");
    }

    // Test withdrawal with insufficient funds
    @Test
    public void testInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0),
                "Should throw exception for insufficient funds");
    }
}
