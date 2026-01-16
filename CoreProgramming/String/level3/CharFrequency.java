package String.level3;

import java.util.Scanner;

/*
 * Program: Character Frequency (ASCII Array)
 * Purpose: Finds the frequency of characters in a string using an ASCII frequency array.
 */
public class CharFrequency {

    // Helper to find length
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

    // Findings frequency of characters
    public static String[][] findFrequency(String text) {
        int len = findLength(text);
        int[] freq = new int[256]; // ASCII size

        // Count frequency
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        // Count non-zero frequencies to size the result array
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        String[][] result = new String[count][2];
        int k = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[k][0] = String.valueOf((char) i);
                result[k][1] = String.valueOf(freq[i]);
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        String[][] frequency = findFrequency(text);

        System.out.println("Character Frequency:");
        System.out.printf("%-10s %-10s%n", "Char", "Frequency");
        System.out.println("--------------------");
        for (String[] row : frequency) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }

        scanner.close();
    }
}
