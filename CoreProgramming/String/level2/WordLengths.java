package String.level2;

import java.util.Scanner;

/*
 * Program: Word Lengths Tabulator
 * Purpose: Identifies words in a sentence and displays them alongside their lengths.
 */
public class WordLengths {

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

        // Count words
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

        // Extract words
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

    // Creates 2D array with words and lengths
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitText(text);
        String[][] wordsAndLengths = getWordLengths(words);

        System.out.printf("%-20s %-10s%n", "Word", "Length");
        System.out.println("------------------------------");
        for (String[] row : wordsAndLengths) {
            System.out.printf("%-20s %-10d%n", row[0], Integer.parseInt(row[1]));
        }

        scanner.close();
    }
}
