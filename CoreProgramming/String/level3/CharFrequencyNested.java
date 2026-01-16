package String.level3;

import java.util.Scanner;

/*
 * Program: Character Frequency (Nested Loops)
 * Purpose: Finds frequency of characters in a string using nested loops.
 */
public class CharFrequencyNested {

    // Helper to find length manually
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

    // Finds frequency using nested loops and char array to mark visited
    public static void findFrequency(String text) {
        int len = findLength(text);
        char[] chars = text.toCharArray();
        int[] freq = new int[len];

        // Loop to count frequency
        for (int i = 0; i < len; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    // Mark as visited to avoid counting again
                    chars[j] = '0';
                }
            }
        }

        // Display
        System.out.println("Character Frequency (Nested Loop):");
        System.out.printf("%-10s %-10s%n", "Char", "Frequency");
        System.out.println("--------------------");
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0' && chars[i] != ' ') {
                System.out.printf("%-10s %-10s%n", chars[i], freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        findFrequency(text);

        scanner.close();
    }
}
