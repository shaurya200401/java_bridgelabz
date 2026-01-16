package Extras;

import java.util.Scanner;

/*
 * Program: Palindrome Checker
 * Purpose: Checks if a given string is a palindrome.
 */
public class PalindromeChecker {

    // Method to check if string is palindrome
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lower case
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleanStr.length() - 1;

        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Display outcome
        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
        sc.close();
    }
}
