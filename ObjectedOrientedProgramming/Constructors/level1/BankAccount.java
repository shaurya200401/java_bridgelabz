package Constructors.level1;
/*
 * BankAccount Class
 * Demonstrates access modifiers in a banking context.
 * Account Number (public), Account Holder (protected), Balance (private).
 */
public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ACC1001", "Bob Smith", 5000.0);
        sa.displayAccountInfo();
        sa.deposit(1000);
        System.out.println("New Balance: " + sa.getBalance());
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber); // Public
        System.out.println("Account Holder: " + accountHolder); // Protected
        // System.out.println("Balance: " + balance); // Private: Not accessible
        System.out.println("Balance: " + getBalance());
    }
}
