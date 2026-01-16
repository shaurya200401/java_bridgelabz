package String.level1;

import java.util.Scanner;

/*
 * Program: String Index Out of Bounds
 * Purpose: Demonstrates handling exceptions when accessing invalid string indices.
 */
public class outofbound {

    // Method to trigger StringIndexOutOfBoundsException
    public static void generate(String s) {
        System.out.println(s.charAt(s.length() + 1));
    }

    // Method to handle exception
    public static void handle(String s) {
        try {
            System.out.println(s.charAt(s.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Index Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        handle(text);
        sc.close();
    }
}
