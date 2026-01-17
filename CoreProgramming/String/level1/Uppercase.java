package String.level1;

import java.util.Scanner;

/*
 * Program: Convert to Uppercase
 * Purpose: Manually converts lowercase characters in a string to uppercase.
 */
public class Uppercase {

    // Method to convert string to uppercase
    public static String toUpper(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Check if char is lowercase
            if (ch >= 'a' && ch <= 'z') {
                res += (char) (ch - 32);
            } else {
                res += ch;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Compare manual vs built-in
        String manual = toUpper(text);
        String builtIn = text.toUpperCase();

        System.out.println("Manual: " + manual + " | Comparison: " + manual.equals(builtIn));
        sc.close();
    }
}
