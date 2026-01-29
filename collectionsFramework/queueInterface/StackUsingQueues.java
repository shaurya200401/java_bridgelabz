package collectionsFramework.queueInterface;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements a Stack data structure using two Queues.
 * It supports push, pop, and top operations following LIFO (Last-In-First-Out)
 * principle.
 */
public class StackUsingQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     * Cost: O(n) because we move all elements to maintain stack order in q1.
     * 
     * @param x Element to push
     */
    public void push(int x) {
        // Enqueue x to q2
        q2.add(x);

        // Dequeue everything from q1 and enqueue to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Removes the element on the top of the stack.
     * Cost: O(1)
     * 
     * @return The popped element
     */
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.poll();
    }

    /**
     * Get the top element.
     * Cost: O(1)
     * 
     * @return The top element
     */
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        System.out.println("Pushing 1");
        stack.push(1);
        System.out.println("Pushing 2");
        stack.push(2);
        System.out.println("Pushing 3");
        stack.push(3);

        System.out.println("Pop: " + stack.pop()); // Should be 3
        System.out.println("Top: " + stack.top()); // Should be 2
        System.out.println("Pop: " + stack.pop()); // Should be 2

        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Pop: " + stack.pop()); // Should be 1
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
