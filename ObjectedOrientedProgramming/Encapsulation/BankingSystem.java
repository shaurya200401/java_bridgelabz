package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * BankingSystem Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * BankAccount is the abstract superclass.
 * Loanable is an interface.
 */
public class BankingSystem {

    interface Loanable {
        void applyForLoan(double amount);

        boolean calculateLoanEligibility(double amount);
    }

    static abstract class BankAccount implements Loanable {
        private String accountNumber;
        private String holderName;
        private double balance;

        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public double getBalance() {
            return balance;
        }

        // Setter for balance is protected/private, modified only via deposit/withdraw
        protected void setBalance(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + ". New Balance: $" + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        }

        public abstract double calculateInterest();

        @Override
        public void applyForLoan(double amount) {
            if (calculateLoanEligibility(amount)) {
                System.out.println("Loan of $" + amount + " approved.");
            } else {
                System.out.println("Loan of $" + amount + " denied.");
            }
        }

        public void displayAccountInfo() {
            System.out.println("Account: " + accountNumber + ", Holder: " + holderName);
            System.out.println("Balance: $" + balance);
            System.out.println("Interest Amount: $" + calculateInterest());
        }
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate = 0.04; // 4%

        public SavingsAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        public double calculateInterest() {
            return getBalance() * interestRate;
        }

        @Override
        public boolean calculateLoanEligibility(double amount) {
            // Can loan up to 2x balance
            return amount <= getBalance() * 2;
        }
    }

    static class CurrentAccount extends BankAccount {
        private double overdraftLimit = 1000;

        public CurrentAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        public double calculateInterest() {
            return 0; // Current accounts usually have no interest
        }

        @Override
        public boolean calculateLoanEligibility(double amount) {
            // Can loan up to 5x balance due to higher turnover
            return amount <= getBalance() * 5;
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrew $" + amount + ". New Balance: $" + getBalance());
            } else {
                System.out.println("Overdraft limit exceeded.");
            }
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA101", "John", 5000));
        accounts.add(new CurrentAccount("CA202", "Jane", 10000));

        System.out.println("Banking System Details:");
        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
            acc.deposit(500);
            acc.withdraw(200);
            acc.applyForLoan(20000); // Check loan
            System.out.println("-------------------------");
        }
    }
}
