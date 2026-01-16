package String.Extras;

import java.util.Scanner;

/*
 * Program: Reverse String
 * Purpose: Reverses a string input by the user.
 */
public class ReverseString {

    // Method to reverse string
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Show reversed string
        System.out.println("Reversed string: " + reverse(input));
        sc.close();
    }
}
