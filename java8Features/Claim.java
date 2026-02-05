package java8Features;

import java.time.LocalDate;

/**
 * Claim class for Problem 4: Claims Analysis.
 * Attributes: claimId, policyNumber, claimAmount, claimDate, status.
 */
public class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private LocalDate claimDate;
    private String status;

    public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Claim{ID='" + claimId + "', policy='" + policyNumber + "', amt=" + claimAmount + ", status='" + status
                + "'}";
    }
}
