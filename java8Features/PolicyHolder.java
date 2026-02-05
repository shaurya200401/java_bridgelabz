package java8Features;

/**
 * PolicyHolder class for Problem 5: Risk Assessment.
 * Attributes: holderId, name, age, policyType, premiumAmount.
 */
public class PolicyHolder {
    private String holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return name + " (" + age + " yrs)";
    }
}
