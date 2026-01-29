package collectionsFramework.listInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class demonstrates how to reverse the elements of a List (ArrayList and LinkedList)
 * without using the built-in Collections.reverse() method.
 */
public class ListReversal {

    public static void main(String[] args) {
        // Create an ArrayList with initial values
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        // Reverse the ArrayList
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // Create a LinkedList with initial values
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        System.out.println("\nOriginal LinkedList: " + linkedList);
        // Reverse the LinkedList
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    /**
     * Reverses the given list in-place.
     * Works for both ArrayList and LinkedList, though efficient random access
     * is preferred for this swap-based approach.
     * 
     * @param list The list to reverse
     */
    private static void reverseList(List<Integer> list) {
        // Initialize start and end pointers
        int start = 0;
        int end = list.size() - 1;

        // Loop until the two pointers meet
        while (start < end) {
            // Retrieve values at start and end indices
            Integer temp = list.get(start);
            
            // Swap the values
            list.set(start, list.get(end));
            list.set(end, temp);

            // Move pointers towards the center
            start++;
            end--;
        }
    }
}
