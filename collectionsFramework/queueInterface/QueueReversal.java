package collectionsFramework.queueInterface;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class demonstrates how to reverse a Queue using recursion.
 * Accessing the call stack allows us to reverse the queue without an explicit
 * external data structure,
 * essentially relying on standard queue operations (poll/add) and recursion.
 */
public class QueueReversal {

    public static void main(String[] args) {
        // Initialize the queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }

    /**
     * Reverses the queue using recursion.
     * 
     * @param queue The queue to reverse
     */
    public static void reverseQueue(Queue<Integer> queue) {
        // Base case: if queue is empty, return
        if (queue.isEmpty()) {
            return;
        }

        // Dequeue current item
        // Step 1: Remove element from front
        int data = queue.poll();

        // Step 2: Recursive call for the rest of the queue
        reverseQueue(queue);

        // Step 3: Add the element back to the rear
        // Because of recursion, the first item removed (10) will be added last,
        // and the last item removed (30) will be added first.
        queue.add(data);
    }
}
