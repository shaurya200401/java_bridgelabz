package String.level3;

import java.util.Scanner;

// Program to find frequency of characters by finding unique characters first
public class CharFrequencyUnique {

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

    // Function to finds unique characters
    public static char[] uniqueCharacters(String text) {
        int len = findLength(text);
        char[] unique = new char[len]; // max possible size
        int k = 0;

        for (int i = 0; i < len; i++) {
            boolean seen = false;
            for (int j = 0; j < k; j++) {
                if (unique[j] == text.charAt(i)) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                unique[k++] = text.charAt(i);
            }
        }

        // Trim array
        char[] result = new char[k];
        System.arraycopy(unique, 0, result, 0, k);
        return result;
    }

    // Finds frequency using unique characters array
    public static String[][] findFrequency(String text) {
        char[] unique = uniqueCharacters(text);
        int len = findLength(text);
        String[][] results = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            char u = unique[i];
            int count = 0;
            // Iterate text to count occurrences
            for (int j = 0; j < len; j++) {
                if (text.charAt(j) == u) {
                    count++;
                }
            }
            results[i][0] = String.valueOf(u);
            results[i][1] = String.valueOf(count);
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        String[][] frequency = findFrequency(text);

        System.out.println("Character Frequency (Unique Method):");
        System.out.printf("%-10s %-10s%n", "Char", "Frequency");
        System.out.println("--------------------");
        for (String[] row : frequency) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }

        scanner.close();
    }
}

