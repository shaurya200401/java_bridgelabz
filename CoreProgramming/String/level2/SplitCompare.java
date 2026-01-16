package String.level2;

import java.util.Scanner;

/*
 * Program: Split and Compare
 * Purpose: Manually splits a string and compares result with built-in split method.
 */
public class SplitCompare {

    // Helper method to find length manually
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

    // Splits text into words manually
    public static String[] splitText(String text) {
        int len = findLength(text);
        int wordCount = 0;

        // Count words first
        boolean isWord = false;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ') {
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
            } else {
                isWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = 0;
        boolean parsingWord = false;

        // Extract words using indices
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ') {
                if (!parsingWord) {
                    start = i;
                    parsingWord = true;
                }
            } else {
                if (parsingWord) {
                    String sub = "";
                    for (int k = start; k < i; k++) {
                        sub += text.charAt(k);
                    }
                    words[wordIndex++] = sub;
                    parsingWord = false;
                }
            }
        }
        // Handle last word
        if (parsingWord) {
            String sub = "";
            for (int k = start; k < len; k++) {
                sub += text.charAt(k);
            }
            words[wordIndex] = sub;
        }

        return words;
    }

    // Compares two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        String[] manualSplit = splitText(text);
        String[] builtInSplit = text.trim().split("\\s+"); // Regex for robust whitespace handling

        if (text.trim().isEmpty()) {
            builtInSplit = new String[0];
        }

        System.out.println("Manual Split Results:");
        for (String s : manualSplit)
            System.out.println(s);

        System.out.println("Comparison Result: " + compareArrays(manualSplit, builtInSplit));

        scanner.close();
    }
}
