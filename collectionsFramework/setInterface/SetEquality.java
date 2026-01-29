package collectionsFramework.setInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * This class demonstrates how to compare two Sets for equality.
 * In Java, Set.equals() checks if both sets have the same size and contain the
 * same elements,
 * regardless of their internal order.
 */
public class SetEquality {

    public static void main(String[] args) {
        // Create first set
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Create second set with different insertion order
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Check if sets are equal
        boolean areEqual = checkEquality(set1, set2);
        System.out.println("Are sets equal? " + areEqual);
    }

    /**
     * Checks if two sets are equal.
     * 
     * @param set1 First set
     * @param set2 Second set
     * @return true if both sets contain the same elements, false otherwise
     */
    public static boolean checkEquality(Set<Integer> set1, Set<Integer> set2) {
        // The equals method for Set is defined to return true if the two sets
        // have the same size and contain the same elements.
        return set1.equals(set2);
    }
}
