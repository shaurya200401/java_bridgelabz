package ObjectedOrientedProgramming.Inheritance;

/*
 * BankAccountSystem Class
 * Demonstrates hierarchical inheritance.
 * BankAccount is the superclass; SavingsAccount, CheckingAccount, and FixedDepositAccount are subclasses.
 */

public class BankAccountSystem {

    static class BankAccount {
        String accountNumber;
        double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void displayAccountType() {
            System.out.println("Unknown Account Type");
        }

        public void displayDetails() {
            System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
        }
    }

    static class SavingsAccount extends BankAccount {
        double interestRate;

        public SavingsAccount(String accountNumber, double balance, double interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        @Override
        public void displayAccountType() {
            System.out.println("Type: Savings Account (Interest Rate: " + interestRate + "%)");
        }
    }

    static class CheckingAccount extends BankAccount {
        double withdrawalLimit;

        public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
            super(accountNumber, balance);
            this.withdrawalLimit = withdrawalLimit;
        }

        @Override
        public void displayAccountType() {
            System.out.println("Type: Checking Account (Withdrawal Limit: $" + withdrawalLimit + ")");
        }
    }

    static class FixedDepositAccount extends BankAccount {
        int lockInPeriodMonths;

        public FixedDepositAccount(String accountNumber, double balance, int lockInPeriodMonths) {
            super(accountNumber, balance);
            this.lockInPeriodMonths = lockInPeriodMonths;
        }

        @Override
        public void displayAccountType() {
            System.out.println("Type: Fixed Deposit Account (Lock-in: " + lockInPeriodMonths + " months)");
        }
    }

    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA001", 5000, 3.5);
        BankAccount checking = new CheckingAccount("CA002", 2000, 1000);
        BankAccount fd = new FixedDepositAccount("FD003", 10000, 12);

        BankAccount[] accounts = { savings, checking, fd };

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            acc.displayAccountType();
            System.out.println("-----------------");
        }
    }
}
