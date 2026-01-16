package String.lvl2;

import java.util.Scanner;

// Program to find and return the length of a string without using the length() method
public class StringLength {

    // Finds the length of a string without using the built-in length() method
    public static int findLength(String text) {
        int count = 0;
        try {
            // Infinite loop to count until exception
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.next();

        int lengthManual = findLength(input);
        int lengthBuiltIn = input.length();

        System.out.println("Length using manual method: " + lengthManual);
        System.out.println("Length using built-in length(): " + lengthBuiltIn);

        scanner.close();
    }
}
