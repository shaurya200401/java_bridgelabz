package dataStructures.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to remove duplicate characters from a string using StringBuilder.
 */
public class RemoveDuplicatesSb {

    // Method to remove duplicates using StringBuilder and HashSet
    public static String removeDuplicates(String input) {
        // Initialize an empty StringBuilder and a HashSet to keep track of characters
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        // Iterate over each character in the string
        for (char c : input.toCharArray()) {
            // If the character is not in the HashSet, append it to the StringBuilder and
            // add it to the HashSet
            if (!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }

        // Return the StringBuilder as a string without duplicates
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);

        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + result);
    }
}
