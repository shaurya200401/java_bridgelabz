package String.Extras;

import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String target = sc.nextLine();
        System.out.print("Enter replacement word: ");
        String replacement = sc.nextLine();

        String[] words = sentence.split("\\s+");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                result += replacement;
            } else {
                result += words[i];
            }

            if (i < words.length - 1) {
                result += " ";
            }
        }

        System.out.println("Modified sentence: " + result);
        sc.close();
    }
}
