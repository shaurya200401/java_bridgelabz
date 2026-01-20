package DataStructures.HashmapsandFunctions;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to find the length of the longest consecutive elements sequence.
 * It uses a HashSet to store elements for O(1) retrieval and checks for
 * consecutive sequences.
 */
public class LongestConsecutiveSequence {

    // Method to find the length of the longest consecutive sequence
    public static int findLongestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            // Check if it is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for next consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int longest = findLongestConsecutiveSequence(nums);
        System.out.println("Longest consecutive sequence length: " + longest);
    }
}
