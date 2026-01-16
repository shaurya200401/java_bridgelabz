package CoreProgramming.String.lvl3;

import java.util.Scanner;

// Program to check if text is a palindrome using 3 different logic approaches
public class PalindromeCheck {

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

    // Logic 1: Iterative comparison from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = findLength(text) - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using Arrays (reversing char array)
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];
        int len = original.length;

        for (int i = 0; i < len; i++) {
            reverse[i] = original[len - 1 - i];
        }

        for (int i = 0; i < len; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.next(); // Single word usually

        System.out.println("Logic 1 (Iterative): " + isPalindromeIterative(text));
        System.out.println("Logic 2 (Recursive): " + isPalindromeRecursive(text, 0, findLength(text) - 1));
        System.out.println("Logic 3 (Array Reverse): " + isPalindromeArray(text));

        scanner.close();
    }
}
