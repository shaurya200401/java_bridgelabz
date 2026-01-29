package collectionsFramework.setInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * This class demonstrates how to perform Union and Intersection operations
 * on two Sets using standard Java Collection methods.
 */
public class SetOperations {

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

        // Compute Union
        Set<Integer> union = getUnion(set1, set2);
        System.out.println("Union: " + union);

        // Compute Intersection
        Set<Integer> intersection = getIntersection(set1, set2);
        System.out.println("Intersection: " + intersection);
    }

    /**
     * Returns the union of two sets (elements in either set).
     * 
     * @param s1 First set
     * @param s2 Second set
     * @return A new set containing the union
     */
    public static Set<Integer> getUnion(Set<Integer> s1, Set<Integer> s2) {
        // Create a copy of s1 to avoid modifying the original set
        Set<Integer> union = new HashSet<>(s1);
        // Add all elements from s2
        union.addAll(s2);
        return union;
    }

    /**
     * Returns the intersection of two sets (elements common to both).
     * 
     * @param s1 First set
     * @param s2 Second set
     * @return A new set containing the intersection
     */
    public static Set<Integer> getIntersection(Set<Integer> s1, Set<Integer> s2) {
        // Create a copy of s1
        Set<Integer> intersection = new HashSet<>(s1);
        // Retain only elements that are also in s2
        intersection.retainAll(s2);
        return intersection;
    }
}
