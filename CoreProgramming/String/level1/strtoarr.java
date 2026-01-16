package String.level1;

import java.util.Scanner;

/*
 * Program: String to Character Array
 * Purpose: Manually converts a string to a char array and compares with built-in method.
 */
public class strtoarr {

    // Method to convert string to char array
    public static char[] getChars(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length)
            return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        // Convert manually and using built-in
        char[] manualArr = getChars(text);
        char[] builtInArr = text.toCharArray();

        System.out.println("Arrays match: " + compareArrays(manualArr, builtInArr));
        sc.close();
    }
}
