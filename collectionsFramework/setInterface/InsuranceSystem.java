package collectionsFramework.setInterface;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * This class implements an Insurance Policy Management System using different
 * Set implementations.
 * It demonstrates checking for uniqueness, order maintenance, and sorting
 * capabilities.
 */
public class InsuranceSystem {

    // Policy class to represent individual policies
    static class Policy implements Comparable<Policy> {
        private String policyNumber; // Unique Identifier
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
                double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public String getPolicyholderName() {
            return policyholderName;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        @Override
        public String toString() {
            return String.format("Policy{No='%s', Name='%s', Exp=%s, Type='%s', Prem=%.2f}",
                    policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
        }

        // Override equals and hashCode based on policyNumber for uniqueness in
        // HashSet/LinkedHashSet
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Policy policy = (Policy) o;
            return Objects.equals(policyNumber, policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        // Compare by Expiry Date for TreeSet
        @Override
        public int compareTo(Policy other) {
            // First compare by Expiry Date
            int dateComparison = this.expiryDate.compareTo(other.expiryDate);
            if (dateComparison != 0) {
                return dateComparison;
            }
            // If expiry dates are same, fall back to policy number to distinguish unique
            // policies
            return this.policyNumber.compareTo(other.policyNumber);
        }
    }

    public static void main(String[] args) {
        // 1. Store Unique Policies using different Sets
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(); // Uses compareTo (Expiry Date)

        // Sample Data (includes duplicates and different dates)
        Policy p1 = new Policy("P001", "Alice", LocalDate.of(2026, 3, 15), "Health", 500.0);
        Policy p2 = new Policy("P002", "Bob", LocalDate.of(2026, 2, 10), "Auto", 300.0);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.of(2026, 5, 20), "Home", 200.0);
        Policy p4 = new Policy("P001", "Alice Duplicate", LocalDate.of(2026, 3, 15), "Health", 500.0); // Duplicate ID
        Policy p5 = new Policy("P004", "David", LocalDate.of(2026, 2, 5), "Auto", 350.0); // Expiring soon

        List<Policy> rawList = Arrays.asList(p1, p2, p3, p4, p5);

        System.out.println("Processing " + rawList.size() + " raw policies...");

        // Populate Sets
        for (Policy p : rawList) {
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
        }

        // Display contents
        System.out.println("\n--- HashSet (Unordered, Unique by ID) ---");
        hashSet.forEach(System.out::println);

        System.out.println("\n--- LinkedHashSet (Insertion Order, Unique by ID) ---");
        linkedHashSet.forEach(System.out::println);

        System.out.println("\n--- TreeSet (Sorted by Expiry Date) ---");
        treeSet.forEach(System.out::println);

        // 2. Retrieve Policies
        System.out.println("\n--- Retrieval Operations ---");

        // Policies expiring soon (within 30 days from now)
        // For simulation, let's assume 'now' is 2026-02-01
        LocalDate simulatedNow = LocalDate.of(2026, 2, 1);
        System.out.println("Policies expiring within 30 days of " + simulatedNow + ":");
        for (Policy p : hashSet) {
            long daysUntilExpiry = ChronoUnit.DAYS.between(simulatedNow, p.getExpiryDate());
            if (daysUntilExpiry >= 0 && daysUntilExpiry <= 30) {
                System.out.println(p);
            }
        }

        // Policies with specific coverage type
        String targetType = "Auto";
        System.out.println("\nPolicies with coverage type '" + targetType + "':");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(targetType)) {
                System.out.println(p);
            }
        }

        // Duplicate policies based on policy numbers from the raw list
        System.out.println("\nCheck for Duplicates in Raw List:");
        Set<String> processedIds = new HashSet<>();
        for (Policy p : rawList) {
            if (!processedIds.add(p.getPolicyNumber())) {
                System.out.println(
                        "Duplicate Policy Found: " + p.getPolicyNumber() + " (" + p.getPolicyholderName() + ")");
            }
        }

        // 3. Performance Comparison
        System.out.println("\n--- Performance Comparison (100,000 operations) ---");
        comparePerformance();
    }

    private static void comparePerformance() {
        int ops = 100000;
        Set<Integer> hSet = new HashSet<>();
        Set<Integer> lhSet = new LinkedHashSet<>();
        Set<Integer> tSet = new TreeSet<>();

        long startTime, endTime;

        // HashSet Add
        startTime = System.nanoTime();
        for (int i = 0; i < ops; i++)
            hSet.add(i);
        endTime = System.nanoTime();
        System.out.println("HashSet Add: " + (endTime - startTime) / 1_000_000 + " ms");

        // LinkedHashSet Add
        startTime = System.nanoTime();
        for (int i = 0; i < ops; i++)
            lhSet.add(i);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add: " + (endTime - startTime) / 1_000_000 + " ms");

        // TreeSet Add
        startTime = System.nanoTime();
        for (int i = 0; i < ops; i++)
            tSet.add(i);
        endTime = System.nanoTime();
        System.out.println("TreeSet Add: " + (endTime - startTime) / 1_000_000 + " ms");

        // HashSet Search
        startTime = System.nanoTime();
        for (int i = 0; i < ops; i++)
            hSet.contains(i);
        endTime = System.nanoTime();
        System.out.println("HashSet Search: " + (endTime - startTime) / 1_000_000 + " ms");

        // TreeSet Search (Slower due to log n)
        startTime = System.nanoTime();
        for (int i = 0; i < ops; i++)
            tSet.contains(i);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
