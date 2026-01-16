package String.level3;

import java.util.Scanner;

/*
 * Program: First Non-Repeating Character
 * Purpose: Identifies the first character in a string that does not repeat.
 */
public class FirstNonRepeating {

    // Find length manually
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

    // Finds the first non-repeating character
    public static char findFirstNonRepeating(String text) {
        int len = findLength(text);
        int[] freq = new int[256]; // ASCII size

        // Calculate frequencies
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        // Find first char with frequency 1
        for (int i = 0; i < len; i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Null char if none found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeating(text);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
}
