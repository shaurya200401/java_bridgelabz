package OOPFundamentals.level2;

/*
 * Program: ATM Simulation
 * Purpose: Defines a BankAccount class with deposit, withdraw, and balance display functionality.
 */
public class BankAccount {
    // Account details
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor to initialize account
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit valid amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw if sufficient balance exists
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to show balance
    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        // Create account instance
        BankAccount account = new BankAccount("John Doe", "1234567890", 1000.00);

        // Execute transactions
        account.displayBalance();
        account.deposit(500);
        account.withdraw(200);
        account.displayBalance();
    }
}
