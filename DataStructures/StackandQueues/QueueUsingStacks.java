package DataStructures.StackandQueues;

import java.util.Stack;

/**
 class implements a Queue data structure using two Stacks.
 This demonstrates how to perform FIFO operations using LIFO data structures.
 */
public class QueueUsingStacks {
    // Stack for enqueue operations
    private Stack<Integer> stack1;
    // Stack for dequeue operations
    private Stack<Integer> stack2;

    // Constructor to initialize stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to add an element to the queue
    public void enqueue(int x) {
        // Push element to stack1
        stack1.push(x);
        // Print action
        System.out.println("Enqueued: " + x);
    }

    // Method to remove an element from the queue
    public int dequeue() {
        // If both stacks are empty, queue is empty
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop the top element from stack2
        int popped = stack2.pop();
        System.out.println("Dequeued: " + popped);
        return popped;
    }

    // Main method to test the QueueUsingStacks class
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();

        // Enqueue elements
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Dequeue elements
        q.dequeue(); // Should remove 1
        q.dequeue(); // Should remove 2

        // Enqueue more
        q.enqueue(4);

        // Dequeue remaining
        q.dequeue(); // Should remove 3
        q.dequeue(); // Should remove 4
        q.dequeue(); // Should be empty
    }
}
