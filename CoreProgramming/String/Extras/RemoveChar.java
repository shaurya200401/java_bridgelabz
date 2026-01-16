package String.Extras;

import java.util.Scanner;

/*
 * Program: Remove Specific Character
 * Purpose: Removes all occurrences of a specified character from a string.
 */
public class RemoveChar {

    // Method to remove character
    public static String removeCharacter(String str, char ch) {
        // Use replace method to remove the char (convert char to string first)
        // Or build a new string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char ch = sc.next().charAt(0);

        // Process and display
        String result = removeCharacter(input, ch);
        System.out.println("Result: " + result);
        sc.close();
    }
}
