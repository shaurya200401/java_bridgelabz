package dataStructures.hashmapsandFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to find all subarrays with zero sum.
 * It uses a HashMap to store the cumulative sum and its frequency.
 */
public class ZeroSumSubarrays {

    // Method to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // Map to store sum and list of indices where this sum occurs
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Initialize map with sum 0 at index -1 to handle subarrays starting from index
        // 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum exists in map, it means there are subarrays ending at i with sum 0
            if (map.containsKey(sum)) {
                List<Integer> startIndices = map.get(sum);
                for (int start : startIndices) {
                    result.add(new int[] { start + 1, i });
                }
            }

            // Add current sum and index to map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println("Subarray from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}
