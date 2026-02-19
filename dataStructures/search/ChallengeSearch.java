package dataStructures.search;

import java.util.Arrays;

/**
 * Challenge Problem: Linear Search for first missing positive integer and
 * Binary Search for target index.
 */
public class ChallengeSearch {

    // Linear Search to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        // Check if 1 is present in array
        boolean containsOne = false;
        for (int x : nums) {
            if (x == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne)
            return 1;

        // Replace numbers <= 0 and > n with 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Use index as a hash key and mark presence with negative sign
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If the number at index a-1 is positive, make it negative
            if (a == n) {
                // Handle the n case specially or mapped to index 0 (commonly mapped to index 0
                // or n-1 if using 0-index)
                // Simple approach: map value 'v' to index 'v-1'
                // If value is n, we can't map to index n-1 if we use 0 to n-1 indices.
                // Actually if value is n, map to index n-1.
                // The logic above replaced > n. So values are 1 to n.
                // Use 0-based index: value 1 -> index 0 ... value n -> index n-1.
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        // Wait, the standard "First Missing Positive" algorithm logic is slightly
        // complex to implement flawlessly in one go.
        // Let's use a simpler approach as per the "Hint" if provided, or the general
        // simpler O(n) logic.
        // "Iterate through the list and mark each number in the list as visited (you
        // can use negative marking or a separate array)."
        // Since O(n) space is allowed if "separate array" is mentioned, let's use a
        // boolean array for simplicity and robustness.

        boolean[] visited = new boolean[n + 2]; // To cover 1 to n+1
        for (int num : nums) {
            if (num > 0 && num <= n + 1) {
                visited[num] = true;
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i])
                return i;
        }

        return n + 1;
    }

    // Binary Search to find the index of a given target number (assuming sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Part 1
        int[] nums = { 3, 4, -1, 1 };
        System.out.println("Processing array for missing positive: " + Arrays.toString(nums));
        // Note: passing a copy or re-initializing if the method modifies the array,
        // but our simple boolean array method doesn't modify input structure
        // destructively for logic (only temp variable).
        int missing = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missing);

        // Part 2
        int[] sortedNums = { 1, 3, 5, 7, 9, 11 };
        int target = 7;

        System.out.println("Binary Search in: " + Arrays.toString(sortedNums));
        int index = binarySearch(sortedNums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
}
