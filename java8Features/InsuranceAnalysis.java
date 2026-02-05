package java8Features;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Comprehensive program to manage and process a list of insurance policies.
 * Implementation of 14 specific tasks using Java 8 Stream API and Lambda expressions.
 */
public class InsuranceAnalysis {
        public static void main(String[] args) {
                // Initializing the list of policies
                List<InsurancePolicy> policies = new ArrayList<>();
                policies.add(new InsurancePolicy("P101", "Alice Smith", 1500.0));
                policies.add(new InsurancePolicy("P102", "Bob Jones", 1100.0));
                policies.add(new InsurancePolicy("P103", "Charlie Brown", 2200.0));
                policies.add(new InsurancePolicy("P104", "David Wilson", 900.0));
                policies.add(new InsurancePolicy("P105", "Eve Davis", 1800.0));
                policies.add(new InsurancePolicy("P106", "Frank Smith", 1300.0));
                policies.add(new InsurancePolicy("P107", "Grace Hall", 2500.0));

                System.out.println("--- All Policies ---");
                policies.forEach(System.out::println);

                // 1. Filter Policies by Premium Amount > $1,200
                System.out.println("\n--- 1. Policies with premium > $1200 ---");
                policies.stream()
                                .filter(p -> p.getPremiumAmount() > 1200)
                                .forEach(System.out::println);

                // 2. Sort Policies by Holder Name using Comparator
                System.out.println("\n--- 2. Policies sorted by Holder Name ---");
                policies.stream()
                                .sorted(Comparator.comparing(InsurancePolicy::getHolderName))
                                .forEach(System.out::println);

                // 3. Compute Total Premium using mapToDouble and sum
                double totalPremium = policies.stream()
                                .mapToDouble(InsurancePolicy::getPremiumAmount)
                                .sum();
                System.out.printf("\n--- 3. Total Premium: $%.2f ---\n", totalPremium);

                // 4. Print Policy Details (Formatted print using forEach)
                System.out.println("\n--- 4. Printing Policy Details ---");
                policies.forEach(p -> System.out.println(p));

                // 5. Filter Policies by Premium Range ($1,000 - $2,000)
                System.out.println("\n--- 5. Policies with premium between $1000 and $2000 ---");
                policies.stream()
                                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                                .forEach(System.out::println);

                // 6. Find Policy with Highest Premium using max()
                System.out.println("\n--- 6. Policy with Highest Premium ---");
                policies.stream()
                                .max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                                .ifPresent(System.out::println);

                // 7. Group Policies by Holder Name Initial using groupingBy collector
                System.out.println("\n--- 7. Policies Grouped by Holder Name Initial ---");
                Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
                                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
                groupedByInitial.forEach((k, v) -> System.out.println(k + ": " + v));

                // 8. Compute Average Premium
                System.out.println("\n--- 8. Average Premium ---");
                policies.stream()
                                .mapToDouble(InsurancePolicy::getPremiumAmount)
                                .average()
                                .ifPresent(avg -> System.out.printf("Average: $%.2f\n", avg));

                // 9. Sort Policies by Premium (Ascending) and Print
                System.out.println("\n--- 9. Policies sorted by Premium (Ascending) ---");
                policies.stream()
                                .sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                                .forEach(System.out::println);

                // 10. Check If Any Policy Exceeds $2,000 using anyMatch
                boolean anyExceeds2000 = policies.stream()
                                .anyMatch(p -> p.getPremiumAmount() > 2000);
                System.out.println("\n--- 10. Any policy > $2000? ---");
                System.out.println(anyExceeds2000 ? "Yes" : "No");

                // 11. Count Policies for Each Premium Range using groupingBy and custom logic
                System.out.println("\n--- 11. Count Policies by Premium Range ---");
                Map<String, Long> rangeCounts = policies.stream()
                                .collect(Collectors.groupingBy(p -> {
                                        double amt = p.getPremiumAmount();
                                        if (amt <= 1000)
                                                return "Low ($0-$1000)";
                                        else if (amt <= 2000)
                                                return "Medium ($1001-$2000)";
                                        else
                                                return "High (>$2000)";
                                }, Collectors.counting()));
                rangeCounts.forEach((k, v) -> System.out.println(k + ": " + v));

                // 12. Extract Unique Holder Names using distinct()
                System.out.println("\n--- 12. Unique Holder Names ---");
                policies.stream()
                                .map(InsurancePolicy::getHolderName)
                                .distinct()
                                .forEach(System.out::println);

                // 13. Find Policies by Holder Name Substring (e.g., "Smith")
                String substring = "Smith";
                System.out.println("\n--- 13. Policies with Holder Name containing '" + substring + "' ---");
                policies.stream()
                                .filter(p -> p.getHolderName().contains(substring))
                                .forEach(System.out::println);

                // 14. Create a Map of Policy Numbers to Premium Amounts
                System.out.println("\n--- 14. Map: Policy Number -> Premium ---");
                Map<String, Double> policyMap = policies.stream()
                                .collect(Collectors.toMap(InsurancePolicy::getPolicyNumber,
                                                InsurancePolicy::getPremiumAmount));
                policyMap.forEach((k, v) -> System.out.println(k + " -> $" + v));
        }
}
