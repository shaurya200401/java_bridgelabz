package String.Extras;

import java.util.Scanner;

/*
 * Program: Remove Duplicates
 * Purpose: Removes duplicate characters from a string, keeping only the first occurrence.
 */
public class RemoveDuplicates {

    // Method to remove duplicates
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Check if char already exists in result builder
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Display unique characters string
        System.out.println("String after removing duplicates: " + removeDuplicates(input));
        sc.close();
    }
}
