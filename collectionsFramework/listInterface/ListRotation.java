package collectionsFramework.listInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates how to rotate the elements of a list by a given
 * number of positions.
 * The example demonstrates a left rotation based on the provided sample
 * input/output.
 */
public class ListRotation {

    public static void main(String[] args) {
        // Create an ArrayList with initial values
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int k = 2;
        System.out.println("Original List: " + list);
        System.out.println("Rotate by: " + k);

        // Perform rotation
        List<Integer> rotatedList = rotateList(list, k);
        System.out.println("Rotated List: " + rotatedList);
    }

    /**
     * Rotates a list by k positions to the left.
     * 
     * @param list The original list
     * @param k    The number of positions to rotate
     * @return A new list containing the rotated elements
     */
    public static List<Integer> rotateList(List<Integer> list, int k) {
        // Handle empty list or invalid k
        if (list == null || list.isEmpty() || k < 0) {
            return list;
        }

        // Optimize k if it's larger than list size
        int rotations = k % list.size();

        // If no rotation needed
        if (rotations == 0) {
            return new ArrayList<>(list);
        }

        // Create a new list for the result
        List<Integer> result = new ArrayList<>();

        // Add elements from index k to the end (the new start)
        // Original: [10, 20, 30, 40, 50], k=2
        // Sublist(2, 5) -> [30, 40, 50]
        result.addAll(list.subList(rotations, list.size()));

        // Add elements from index 0 to k (the new end)
        // Sublist(0, 2) -> [10, 20]
        result.addAll(list.subList(0, rotations));

        return result;
    }
}
