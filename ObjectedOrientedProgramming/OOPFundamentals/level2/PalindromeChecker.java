package OOPFundamentals.level2;

import java.util.Scanner;

/*
 * Program: Palindrome String Checker
 * Purpose: Class to check if a given text string is a palindrome.
 */
public class PalindromeChecker {
    // Input text
    String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Logic to check palindrome
    public boolean checkPalindrome() {
        // Remove spaces and lowercase
        String cleanStr = text.replaceAll("\\s+", "").toLowerCase();
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

    // Display result message
    public void displayResult() {
        if (checkPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to check: ");
        String input = sc.nextLine();

        // Create checker and display
        PalindromeChecker checker = new PalindromeChecker(input);
        checker.displayResult();
        sc.close();
    }
}
