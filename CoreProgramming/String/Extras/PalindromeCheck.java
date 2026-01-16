package String.Extras;

import java.util.Scanner;

/*
 * Program: Palindrome Checker (String)
 * Purpose: Verifies if a user-input string is a palindrome.
 */
public class PalindromeCheck {

    // Method to check palindrome property
    public static boolean isPalindrome(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = clean.length() - 1;

        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Output result
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        sc.close();
    }
}
