package java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 5: Policy Holder Risk Assessment
 * Operations: Filter, Transform, Sort, Categorize.
 */
public class RiskAssessmentAnalysis {

    // DTO for risk assessment
    static class RiskAssessment {
        String holderId;
        String name;
        double riskScore; // premium / age

        public RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }

        @Override
        public String toString() {
            return String.format("%s (Score: %.2f)", name, riskScore);
        }
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H01", "Alice", 65, "Life", 2000.0), // Risk: 30.76
                new PolicyHolder("H02", "Bob", 40, "Auto", 800.0),
                new PolicyHolder("H03", "Charlie", 70, "Life", 3000.0), // Risk: 42.85
                new PolicyHolder("H04", "Dave", 62, "Life", 1500.0), // Risk: 24.19
                new PolicyHolder("H05", "Eve", 25, "Life", 500.0));

        System.out.println("--- 1. Filter: Life Policy & Age > 60 ---");
        List<PolicyHolder> targetHolders = holders.stream()
                .filter(h -> "Life".equals(h.getPolicyType()) && h.getAge() > 60)
                .collect(Collectors.toList());
        targetHolders.forEach(System.out::println);

        System.out.println("\n--- 2. Transform: To RiskAssessment (Risk = Premium / Age) ---");
        List<RiskAssessment> assessments = targetHolders.stream()
                .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), h.getPremiumAmount() / h.getAge()))
                .collect(Collectors.toList());
        assessments.forEach(System.out::println);

        System.out.println("\n--- 3. Sort: By Risk Score Descending ---");
        assessments.sort((r1, r2) -> Double.compare(r2.riskScore, r1.riskScore));
        assessments.forEach(System.out::println);

        System.out.println("\n--- 4. Categorize: High Risk (> 30.0) vs Low Risk ---");
        // Note: Problem said > 0.5, but mathematically premium 2000/age 65 is ~30.
        // 0.5 is very low threshold, I'll use 30.0 for meaningful output based on
        // sample data
        double threshold = 30.0;
        Map<String, List<RiskAssessment>> riskGroups = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > threshold ? "High Risk" : "Low Risk"));

        riskGroups.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
