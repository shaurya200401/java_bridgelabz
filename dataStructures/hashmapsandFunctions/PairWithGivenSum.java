package dataStructures.hashmapsandFunctions;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to check for a pair with a given sum in an array.
 * It uses a HashMap to store visited numbers and check for the complement.
 */
public class PairWithGivenSum {

    // Method to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        // Map to store visited numbers and their usage (or just presence)
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            // Store the current number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Array has a pair with sum " + target);
        } else {
            System.out.println("No pair with sum " + target + " found.");
        }
    }
}
