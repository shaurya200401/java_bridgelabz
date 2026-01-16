package String.Extras;

import java.util.Scanner;

/*
 * Program: Count Vowels and Consonants
 * Purpose: Counts the number of vowels and consonants in a given string.
 */
public class CountVowelsConsonants {

    // Method to count and display vowels and consonants
    public static void count(String str) {
        int vowels = 0, consonants = 0;
        String s = str.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if character is a letter
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Execute count logic
        count(input);
        sc.close();
    }
}
