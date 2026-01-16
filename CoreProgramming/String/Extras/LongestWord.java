package String.Extras;

import java.util.Scanner;

/*
 * Program: Find Longest Word
 * Purpose: Identifies the longest word in a given sentence.
 */
public class LongestWord {

    // Method to find the longest word
    public static String findLongest(String sentence) {
        String[] words = sentence.split("\\s+");
        String longest = "";

        // Iterate through words to find max length
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Get result and print
        String longest = findLongest(input);
        System.out.println("Longest word: " + longest);
        sc.close();
    }
}
