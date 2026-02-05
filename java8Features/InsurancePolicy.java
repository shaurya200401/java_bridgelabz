package java8Features;

/*
 * Model class representing an Insurance Policy.
 * Contains attributes: Policy Number, Holder Name, Premium Amount.
 */
public class InsurancePolicy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    // Constructor to initialize policy details
    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    // Getters for accessing private fields
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    // toString method for easy printing of policy details
    @Override
    public String toString() {
        return String.format("Policy[ID=%s, Holder=%s, Premium=$%.2f]",
                policyNumber, holderName, premiumAmount);
    }
}
