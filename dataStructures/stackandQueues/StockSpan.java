package dataStructures.stackandQueues;

import java.util.Stack;
import java.util.Arrays;

/**
class calculates the span of stock prices for each day.
 */
public class StockSpan {

    // Method to calculate stock span
    public static void calculateSpan(int[] prices, int n, int[] span) {
        Stack<Integer> stack = new Stack<>();

        // Push the first day's index onto the stack
        stack.push(0);

        // Span of the first day is always 1
        span[0] = 1;

        // Calculate span for the rest of the days
        for (int i = 1; i < n; i++) {
            // Pop elements from the stack while the stack is not empty and the top element
            // is smaller than or equal to the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack becomes empty, it means the price on day i is greater than all
            // previous prices
            // Else, the price on day i is greater than prices from stack.peek() + 1 to i -
            // 1
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push the current day's index onto the stack
            stack.push(i);
        }
    }

    // Main method to test the StockSpan class
    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int n = prices.length;
        int[] span = new int[n];

        calculateSpan(prices, n, span);

        System.out.println("Stock Prices: " + Arrays.toString(prices));
        System.out.println("Stock Spans:  " + Arrays.toString(span));
    }
}
