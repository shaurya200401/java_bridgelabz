package String.Extras;

import java.util.Scanner;

/*
 * Program: String Comparison
 * Purpose: Compares two strings lexicographically and checks for equality.
 */
public class StringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        // Check for exact equality
        if (s1.equals(s2)) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are NOT equal.");
        }

        // Check for equality ignoring case
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("Strings are equal (ignoring case).");
        }

        // Lexicographical comparison
        int result = s1.compareTo(s2);
        if (result == 0) {
            System.out.println("Lexicographically equal.");
        } else if (result > 0) {
            System.out.println("String 1 comes after String 2.");
        } else {
            System.out.println("String 1 comes before String 2.");
        }
        sc.close();
    }
}
