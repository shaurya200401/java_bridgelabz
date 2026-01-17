package Operators.level1;

/*
 * BankAccount Class
 * Demonstrates the use of static, this, final, and instanceof.
 * Manages bank accounts with unique, immutable account numbers.
 */
public class BankAccount {
    static String bankName = "Global Bank"; // Shared bank name
    static int totalAccounts = 0; // Shared counter for accounts

    final String accountNumber; // Immutable account number
    String accountHolderName;
    double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber; // Using this to resolve ambiguity and init final var
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++; // Increment total accounts
    }

    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    public void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("AC001", "Alice", 5000.0);

        // Instanceof check
        if (acc1 instanceof BankAccount) {
            System.out.println("Valid BankAccount Object found.");
            acc1.displayDetails();
        }

        BankAccount.getTotalAccounts(); // Call static method
    }
}
