package java8Features;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 6: Fraud Detection
 * Operations: Filter, Group, Aggregate, Alert.
 */
public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "POL100", 15000, LocalDate.now(), true),
                new Transaction("T2", "POL100", 5000, LocalDate.now(), true),
                new Transaction("T3", "POL101", 12000, LocalDate.now(), true),
                new Transaction("T4", "POL100", 20000, LocalDate.now(), true),
                new Transaction("T5", "POL102", 8000, LocalDate.now(), false),
                new Transaction("T6", "POL100", 20000, LocalDate.now(), true),
                new Transaction("T7", "POL100", 5000, LocalDate.now(), true),
                new Transaction("T8", "POL100", 5000, LocalDate.now(), true) // T2, T4, T6, T7, T8 = 5 frauds > 50k?
        );

        System.out.println("--- 1. Filter: Fraud & Amount > $10,000 ---");
        transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .forEach(System.out::println);

        System.out.println("\n--- 2. Group: By Policy Number (All frauds) ---");
        // Limit to only actual fraud transactions for analysis? Or all? Problem implies
        // "these transactions" from step 1,
        // but step 4 implies checking aggregate counts which might come from the master
        // list or just all frauds.
        // I will group ALL FRAUDULENT transactions for proper aggregation.
        Map<String, List<Transaction>> fraudByPolicy = transactions.stream()
                .filter(Transaction::isFraudulent)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));
        fraudByPolicy.forEach((k, v) -> System.out.println(k + " has " + v.size() + " fraud transactions."));

        System.out.println("\n--- 3. Aggregate: Count & Total Fraud Amount per Policy ---");
        Map<String, Double> policyFraudTotals = new HashMap<>();
        Map<String, Long> policyFraudCounts = new HashMap<>();

        fraudByPolicy.forEach((policy, list) -> {
            long count = list.size();
            double total = list.stream().mapToDouble(Transaction::getAmount).sum();
            policyFraudCounts.put(policy, count);
            policyFraudTotals.put(policy, total);
            System.out.printf("Policy %s: Count=%d, Total=$%.2f%n", policy, count, total);
        });

        System.out.println("\n--- 4. Alert: Count > 5 OR Total > $50,000 ---");
        fraudByPolicy.keySet().stream()
                .filter(policy -> policyFraudCounts.get(policy) > 5 || policyFraudTotals.get(policy) > 50000)
                .forEach(policy -> {
                    System.out.println("ALERT! S suspicious Activity on Policy: " + policy);
                });
    }
}
