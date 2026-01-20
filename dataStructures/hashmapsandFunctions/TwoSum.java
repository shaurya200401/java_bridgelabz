package dataStructures.hashmapsandFunctions;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to solve the Two Sum problem.
 * It finds two indices such that their values add up to the target.
 */
public class TwoSum {

    // Method to find indices of the two numbers
    public static int[] twoSum(int[] nums, int target) {
        // Map to store value and its index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        try {
            int[] result = twoSum(nums, target);
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
