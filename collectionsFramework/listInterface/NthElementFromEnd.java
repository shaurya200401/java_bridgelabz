package collectionsFramework.listInterface;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class demonstrates how to find the Nth element from the end of a Singly
 * Linked List
 * (simulated using java.util.LinkedList for this example, or generally using
 * Iterators)
 * without explicitly calculating the full size first.
 */
public class NthElementFromEnd {

    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2; // Find 2nd element from the end

        System.out.println("List: " + list);
        System.out.println("N = " + n);

        String result = findNthFromEnd(list, n);

        if (result != null) {
            System.out.println("Nth element from end: " + result);
        } else {
            System.out.println("List is shorter than N or invalid input.");
        }
    }

    /**
     * Finds the Nth element from the end using the two-pointer (or two-iterator)
     * technique.
     * 
     * @param list The linked list
     * @param n    The position from the end (1-based index)
     * @return The element at the Nth position from the end, or null if invalid
     */
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list == null || n <= 0) {
            return null;
        }

        // Use two iterators
        Iterator<String> fastPtr = list.iterator();
        Iterator<String> slowPtr = list.iterator();

        // Move fastPtr N steps ahead
        int count = 0;
        while (count < n) {
            if (fastPtr.hasNext()) {
                fastPtr.next();
                count++;
            } else {
                // List size is less than N
                return null;
            }
        }

        // Move both pointers one step at a time until fastPtr reaches the end
        while (fastPtr.hasNext()) {
            fastPtr.next();
            slowPtr.next();
        }

        // slowPtr is now at the Nth element from the end
        return slowPtr.next();
    }
}
