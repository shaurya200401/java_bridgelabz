package String.Extras;

import java.util.Scanner;

/*
 * Program: Most Frequent Character
 * Purpose: Finds the character that appears most frequently in a string.
 */
public class MostFrequentChar {

    // Method to find most frequent char
    public static char findMostFrequent(String str) {
        int[] freq = new int[256]; // ASCII size
        String s = str.toLowerCase();

        // Populate frequency array (ignoring spaces)
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                freq[s.charAt(i)]++;
        }

        int max = -1;
        char result = ' ';

        // Find max frequency
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (freq[s.charAt(i)] > max) {
                    max = freq[s.charAt(i)];
                    result = s.charAt(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Display result
        char ch = findMostFrequent(input);
        System.out.println("Most frequent character: " + ch);
        sc.close();
    }
}
