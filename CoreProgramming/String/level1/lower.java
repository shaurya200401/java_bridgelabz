package String.level1;

import java.util.Scanner;

/*
 * Program: Convert to Lowercase
 * Purpose: Manually converts uppercase characters in a string to lowercase.
 */
public class lower {

    // Method to convert string to lowercase
    public static String toLower(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Check if char is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                res += (char) (ch + 32);
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
        String manual = toLower(text);
        String builtIn = text.toLowerCase();

        System.out.println("Manual: " + manual + " | Comparison: " + manual.equals(builtIn));
        sc.close();
    }
}
