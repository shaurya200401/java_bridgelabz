package collectionsFramework.listInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates how to remove duplicate elements from a list
 * while maintaining the original order of elements.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        // Initialize list with duplicates
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));

        System.out.println("Original List: " + numbers);

        // Remove duplicates
        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("After removing duplicates: " + uniqueNumbers);
    }

    /**
     * Removes duplicates from the given list while preserving insertion order.
     * Uses LinkedHashSet internally to achieve this.
     * 
     * @param list The original list with duplicates
     * @return A new list with unique elements in original order
     */
    public static <T> List<T> removeDuplicates(List<T> list) {
        // Create a LinkedHashSet from the list
        // LinkedHashSet automatically removes duplicates and maintains insertion order
        Set<T> set = new LinkedHashSet<>(list);

        // Convert the set back to a List
        return new ArrayList<>(set);
    }
}
