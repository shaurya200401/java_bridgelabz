package collectionsFramework.queueInterface;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class generates binary numbers from 1 to N using a Queue.
 * Logic:
 * 1. Start with "1" in the queue.
 * 2. Dequeue the front element, print it.
 * 3. Append "0" to it and Enqueue.
 * 4. Append "1" to it and Enqueue.
 * 5. Repeat N times.
 */
public class BinaryNumberGenerator {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Generating first " + n + " binary numbers:");

        generateBinaryNumbers(n);
    }

    /**
     * Generates and prints the first n binary numbers.
     * 
     * @param n Number of binary numbers to generate
     */
    public static void generateBinaryNumbers(int n) {
        if (n <= 0)
            return;

        // Queue to store binary strings
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            // Remove the front element
            String current = queue.poll();

            // Print the current binary number
            System.out.println(current);

            // Generate the next two binary numbers
            // Example: if current is "1", add "10" and "11"
            // If current is "10", add "100" and "101"
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
