package DataStructures.StackandQueues;

import java.util.Stack;

/**
class sorts a stack using recursion.
 * This demonstrates the power of recursion in manipulating data structures.
 */
public class SortStackRecursion {

    // Method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: if stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back in sorted order
        sortedInsert(stack, top);
    }

    // Helper method to insert an element into a sorted stack
    public static void sortedInsert(Stack<Integer> stack, int element) {
        // Base case: if stack is empty or top element is smaller than current element
        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
            return;
        }

        // If top is greater, pop it and recurse
        int top = stack.pop();
        sortedInsert(stack, element);

        // Push the top element back
        stack.push(top);
    }

    // Main method to test the SortStackRecursion class
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
