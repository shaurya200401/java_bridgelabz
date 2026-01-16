package String.level3;

import java.util.Scanner;

/*
 * Program: Anagram Checker
 * Purpose: Checks if two strings are anagrams using frequency arrays.
 */
public class AnagramCheck {

    // Helper to find string length manually
    public static int findLength(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (IndexOutOfBoundsException e) {
            return len;
        }
    }

    // Checks if two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {
        int len1 = findLength(text1);
        int len2 = findLength(text2);

        if (len1 != len2)
            return false;

        // Using frequency arrays to check character counts
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < len1; i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String text1 = scanner.next();
        System.out.println("Enter second string: ");
        String text2 = scanner.next();

        boolean result = areAnagrams(text1, text2);
        System.out.println("Are anagrams? " + result);

        scanner.close();
    }
}
