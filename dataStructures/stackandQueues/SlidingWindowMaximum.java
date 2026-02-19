package dataStructures.stackandQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

/**
 class finds the maximum element in each sliding window
 f size k.
 */
public class SlidingWindowMaximum {

    // Method to find maximum of each sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        // Deque to store indices of array elements.
        // Elements in deque are in decreasing order of their values.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove indices of elements that are smaller than the current element
            // as they will not be the maximum in this window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to deque
            deque.offer(i);

            // Store the result for the current window (start storing from index k-1)
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }

        return result;
    }

    // Main method to test the SlidingWindowMaximum class
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Window Size: " + k);

        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximums: " + Arrays.toString(result));
    }
}
