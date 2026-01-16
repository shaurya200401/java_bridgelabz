package String.Extras;

import java.util.Scanner;

/*
 * Program: Toggle Case
 * Purpose: Converts lowercase characters to uppercase and vice versa in a string.
 */
public class ToggleCase {

    // Method to toggle case
    public static String toggle(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // If lowercase, make uppercase
            if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            }
            // If uppercase, make lowercase
            else if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
            // Keep others as is
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Show toggled string
        System.out.println("Toggled String: " + toggle(input));
        sc.close();
    }
}
