package String.level2;

import java.util.Scanner;

/*
 * Program: Shortest and Longest Word
 * Purpose: Identifies the shortest and longest words in a given text string.
 */
public class ShortestLongest {

    // Finds string length manually
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
        if (parsingWord) {
            String sub = "";
            for (int k = start; k < len; k++) {
                sub += text.charAt(k);
            }
            words[wordIndex] = sub;
        }
        return words;
    }

    // Generates 2D array of words and lengths
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Finds shortest and longest words from the array
    public static String[] findShortestLongest(String[][] wordsAndLengths) {
        if (wordsAndLengths.length == 0)
            return new String[] { "", "" };

        String shortestObj = wordsAndLengths[0][0];
        String longestObj = wordsAndLengths[0][0];

        int minLen = Integer.parseInt(wordsAndLengths[0][1]);
        int maxLen = Integer.parseInt(wordsAndLengths[0][1]);

        for (int i = 1; i < wordsAndLengths.length; i++) {
            int currentLen = Integer.parseInt(wordsAndLengths[i][1]);
            String currentWord = wordsAndLengths[i][0];

            if (currentLen < minLen) {
                minLen = currentLen;
                shortestObj = currentWord;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                longestObj = currentWord;
            }
        }

        return new String[] { shortestObj, longestObj };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitText(text);

        if (words.length == 0) {
            System.out.println("No words found.");
            return;
        }

        String[][] wordsAndLengths = getWordLengths(words);
        String[] result = findShortestLongest(wordsAndLengths);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);

        scanner.close();
    }
}
