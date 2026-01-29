package collectionsFramework.mapInterface;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Insurance Policy Management System using Maps.
 * Requirements:
 * - HashMap: Store policies (ID -> Policy) for fast lookup.
 * - LinkedHashMap: Maintain insertion order.
 * - TreeMap: Sorted by expiry date.
 */
public class InsurancePolicySystem {

    static class Policy {
        String policyNumber;
        String policyholderName;
        LocalDate expiryDate;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return String.format("Policy{%s, %s, %s}", policyNumber, policyholderName, expiryDate);
        }
    }

    public static void main(String[] args) {
        // 1. Store Policies
        // Main storage: HashMap for distinct storage by ID
        Map<String, Policy> policyMap = new HashMap<>();
        // Insertion order: LinkedHashMap
        Map<String, Policy> insertionOrderedMap = new LinkedHashMap<>();
        // Sorted by Expiry: TreeMap (Need a trick since TreeMap sorts by KEY usually,
        // not value.
        // But requirements say "Use TreeMap to store policies sorted by expiry date".
        // This implies the Key should probably be ExpiryDate? Or we use value
        // comparator.
        // Storing by ExpiryDate as Key is risky if multiple policies expire same day.
        // A common interpretation is Map<ExpiryDate, List<Policy>> or just use policy
        // object as key if it implements Comparable.
        // Let's deduce: "Use TreeMap to store policies sorted by expiry date."
        // We will stick to the most sensible interpretation: Key=Policy (Sorted),
        // Value=Something(Maybe ID or null)
        // OR better yet, let's make a Map where Key is ID, but we want to iterate in
        // sorted order? No, TreeMap sorts keys.
        // So, let's use ExpiryDate as part of a custom Key or use a comparator on
        // PolicyID if we sort by ID.
        // Wait, "TreeMap to store policies sorted by expiry".
        // Let's use a TreeMap<LocalDate, List<Policy>> for this requirement to handle
        // collisions safe.

        // Sample Data
        Policy p1 = new Policy("P100", "Alice", LocalDate.of(2025, 12, 1));
        Policy p2 = new Policy("P101", "Bob", LocalDate.of(2025, 11, 15)); // Expiring soonest
        Policy p3 = new Policy("P102", "Charlie", LocalDate.of(2026, 1, 20));

        // Populating HashMap
        policyMap.put(p1.policyNumber, p1);
        policyMap.put(p2.policyNumber, p2);
        policyMap.put(p3.policyNumber, p3);
        System.out.println("All Policies (HashMap - Unordered): " + policyMap.values());

        // Populating LinkedHashMap
        insertionOrderedMap.put(p1.policyNumber, p1);
        insertionOrderedMap.put(p2.policyNumber, p2);
        insertionOrderedMap.put(p3.policyNumber, p3);
        System.out.println("All Policies (LinkedHashMap - Insertion Order): " + insertionOrderedMap.values());

        // Populating TreeMap (Sorted by Expiry)
        // Since TreeMap sorts by Key, we'll use LocalDate as Key and List<Policy> as
        // value
        TreeMap<LocalDate, List<Policy>> sortedByExpiry = new TreeMap<>();
        addToDateMap(sortedByExpiry, p1);
        addToDateMap(sortedByExpiry, p2);
        addToDateMap(sortedByExpiry, p3);

        System.out.println("All Policies (TreeMap - Sorted by Expiry):");
        sortedByExpiry.forEach((date, list) -> System.out.println("  " + date + ": " + list));

        // 2. Retrieve and Manipulate
        // Retrieve by number
        System.out.println("\nRetrieve P101: " + policyMap.get("P101"));

        // Policies expiring within 30 days (Assuming 'today' is 2025-11-01)
        LocalDate today = LocalDate.of(2025, 11, 1);
        System.out.println("\nPolicies expiring within 30 days of " + today + ":");
        for (Policy p : policyMap.values()) {
            long days = ChronoUnit.DAYS.between(today, p.expiryDate);
            if (days >= 0 && days <= 30) {
                System.out.println(p);
            }
        }

        // List policies for specific policyholder
        String name = "Alice";
        System.out.println("\nPolicies for " + name + ":");
        for (Policy p : policyMap.values()) {
            if (p.policyholderName.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }

        // Remove expired policies
        System.out.println("\nRemoving expired policies (before " + today + ")...");
        // Safe removal using iterator
        policyMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        System.out.println("Remaining Policies: " + policyMap.values());
    }

    private static void addToDateMap(TreeMap<LocalDate, List<Policy>> map, Policy p) {
        map.computeIfAbsent(p.expiryDate, k -> new ArrayList<>()).add(p);
    }
}
