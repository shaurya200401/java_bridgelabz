package String.Extras;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split("\\s+");
        String longest = "";

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }

        System.out.println("Longest word: " + longest);
        sc.close();
    }
}
