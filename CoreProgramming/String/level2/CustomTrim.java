package String.level2;

import java.util.Scanner;

/*
 * Program: Custom Trim
 * Purpose: Manually removes leading and trailing spaces from a string and compares with built-in trim().
 */
public class CustomTrim {

    // Finds length manually
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // Finds indices for trimming
    public static int[] findTrimIndices(String text) {
        int len = findLength(text);
        int start = 0;
        int end = len - 1;

        // Skip leading spaces
        while (start < len && text.charAt(start) == ' ') {
            start++;
        }

        // Skip trailing spaces
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }

        if (start > end) {
            return new int[] { 0, -1 }; // Empty string case
        }

        return new int[] { start, end };
    }

    // Creates substring manually
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Compares two strings manually
    public static boolean compareStrings(String s1, String s2) {
        int len1 = findLength(s1);
        int len2 = findLength(s2);

        if (len1 != len2)
            return false;

        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] trimIndices = findTrimIndices(text);
        String manualTrimmed;

        if (trimIndices[1] < trimIndices[0]) {
            manualTrimmed = "";
        } else {
            manualTrimmed = createSubstring(text, trimIndices[0], trimIndices[1]);
        }

        String builtInTrimmed = text.trim();

        System.out.println("Manual Trimmed: '" + manualTrimmed + "'");
        System.out.println("Built-in Trimmed: '" + builtInTrimmed + "'");

        boolean areEqual = compareStrings(manualTrimmed, builtInTrimmed);
        System.out.println("Comparison Result: " + areEqual);

        scanner.close();
    }
}
