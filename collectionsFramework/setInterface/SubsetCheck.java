package collectionsFramework.setInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * This class demonstrates how to check if one set is a subset of another.
 * A set A is a subset of set B if all elements of A are also elements of B.
 */
public class SubsetCheck {

    public static void main(String[] args) {
        // Initialize Set 1 (Potential Subset)
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        // Initialize Set 2 (Superset)
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        boolean isSubset = isSubset(set1, set2);
        System.out.println("Is Set 1 a subset of Set 2? " + isSubset);
    }

    /**
     * Checks if subSet is a subset of superSet.
     * 
     * @param subSet   The set to check
     * @param superSet The containing set
     * @return true if all elements of subSet are present in superSet
     */
    public static boolean isSubset(Set<Integer> subSet, Set<Integer> superSet) {
        // containsAll returns true if this set contains all of the elements of the
        // specified collection
        return superSet.containsAll(subSet);
    }
}
