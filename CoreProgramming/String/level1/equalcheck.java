package String.level1;

import java.util.Scanner;

/*
 * Program: Equality Check
 * Purpose: Compares two strings character by character and verifies against built-in .equals().
 */
public class equalcheck {

    // Method to manually compare two strings
    public static boolean manualCompare(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings:");
        String str1 = sc.next();
        String str2 = sc.next();

        // Perform comparisons
        boolean customResult = manualCompare(str1, str2);
        boolean builtInResult = str1.equals(str2);

        System.out.println("Custom Comparison: " + customResult);
        System.out.println("Results match built-in equals(): " + (customResult == builtInResult));
        sc.close();
    }
}
