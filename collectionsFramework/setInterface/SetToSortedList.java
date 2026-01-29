package collectionsFramework.setInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates how to convert a HashSet to a Sorted List.
 * Since HashSet does not guarantee order, we convert it to a List and then sort
 * it.
 */
public class SetToSortedList {

    public static void main(String[] args) {
        // Initialize HashSet with unordered elements
        Set<Integer> numbers = new HashSet<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);

        System.out.println("Original HashSet: " + numbers);

        // Convert and sort
        List<Integer> sortedList = convertAndSort(numbers);

        System.out.println("Sorted List: " + sortedList);
    }

    /**
     * Converts a Set to a sorted List.
     * 
     * @param set The set to convert
     * @return A sorted List containing all elements from the set
     */
    public static List<Integer> convertAndSort(Set<Integer> set) {
        // Convert Set to List
        List<Integer> list = new ArrayList<>(set);

        // Sort the list
        Collections.sort(list);

        return list;
    }
}
