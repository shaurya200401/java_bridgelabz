package String.Extras;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Program: Anagram Checker
 * Purpose: Checks if two strings are anagrams of each other (contain same characters).
 */
public class AnagramCheck {

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase for consistent comparison
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check length first
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert to char arrays and sort
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        // Display result
        if (areAnagrams(str1, str2)) {
            System.out.println("Strings are Anagrams.");
        } else {
            System.out.println("Strings are NOT Anagrams.");
        }
        sc.close();
    }
}
