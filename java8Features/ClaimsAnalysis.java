package java8Features;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 4: Claims Analysis
 * Operations: Filter, Group, Aggregate, Top N.
 */
public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "POL101", 6000.0, LocalDate.now(), "Approved"),
                new Claim("C002", "POL102", 4000.0, LocalDate.now(), "Approved"),
                new Claim("C003", "POL101", 3000.0, LocalDate.now(), "Rejected"),
                new Claim("C004", "POL103", 10000.0, LocalDate.now(), "Approved"),
                new Claim("C005", "POL101", 7000.0, LocalDate.now(), "Approved"),
                new Claim("C006", "POL103", 2000.0, LocalDate.now(), "Pending"));

        System.out.println("--- 1. Filter: Approved & Amount > $5,000 ---");
        claims.stream()
                .filter(c -> "Approved".equals(c.getStatus()) && c.getClaimAmount() > 5000)
                .forEach(System.out::println);

        System.out.println("\n--- 2. Group: By Policy Number ---");
        // Grouping entire list (not just filtered)
        Map<String, List<Claim>> byPolicy = claims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));
        byPolicy.forEach((k, v) -> System.out.println(k + " has " + v.size() + " claims."));

        System.out.println("\n--- 3. Aggregate: Total and Average Claim Amount per Policy ---");
        // Using Maps to store stats
        byPolicy.forEach((policy, policyClaims) -> {
            DoubleSummaryStatistics stats = policyClaims.stream()
                    .mapToDouble(Claim::getClaimAmount)
                    .summaryStatistics();
            System.out.printf("Policy %s: Total=$%.2f, Avg=$%.2f%n", policy, stats.getSum(), stats.getAverage());
        });

        System.out.println("\n--- 4. Top N: Top 3 Policies by Total Claim Amount ---");
        // Create map of Policy -> Total Amount
        Map<String, Double> policyTotals = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getPolicyNumber,
                        Collectors.summingDouble(Claim::getClaimAmount)));

        // Sort and limit
        policyTotals.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + ": $" + e.getValue()));
    }
}
