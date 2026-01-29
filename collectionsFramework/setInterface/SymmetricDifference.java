package collectionsFramework.setInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * This class demonstrates how to compute the Symmetric Difference of two sets.
 * Symmetric Difference contains elements that are in either of the sets, but
 * not in their intersection.
 * Mathematically: (A U B) - (A n B)
 */
public class SymmetricDifference {

    public static void main(String[] args) {
        // Initialize Set 1
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Initialize Set 2
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        Set<Integer> difference = getSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + difference);
    }

    /**
     * Calculates the symmetric difference of two sets.
     * 
     * @param s1 First set
     * @param s2 Second set
     * @return A new set containing the symmetric difference
     */
    public static Set<Integer> getSymmetricDifference(Set<Integer> s1, Set<Integer> s2) {
        // Calculate Union (A U B)
        Set<Integer> union = new HashSet<>(s1);
        union.addAll(s2);

        // Calculate Intersection (A n B)
        Set<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);

        // Symmetric Difference = Union - Intersection
        union.removeAll(intersection);

        return union;
    }
}
