package java8Features;

import java.time.LocalDate;

/**
 * Transaction class for Problem 6: Fraud Detection.
 * Attributes: transactionId, policyNumber, amount, transactionDate,
 * isFraudulent.
 */
public class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private LocalDate transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, LocalDate transactionDate,
            boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    @Override
    public String toString() {
        return "Transaction{ID='" + transactionId + "', Policy='" + policyNumber + "', Amt=" + amount + ", Fraud="
                + isFraudulent + "}";
    }
}
