package String.Extras;

import java.util.Scanner;

/*
 * Program: Replace Word
 * Purpose: Replaces a specific word in a sentence with another word.
 */
public class ReplaceWord {

    // Method to replace word
    public static String replace(String sentence, String oldWord, String newWord) {
        // Using regex replaceAll with word boundaries to ensure whole word replacement
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();

        System.out.print("Enter new word: ");
        String newWord = sc.next();

        // Perform replacement
        String result = replace(sentence, oldWord, newWord);
        System.out.println("Modified sentence: " + result);
        sc.close();
    }
}
