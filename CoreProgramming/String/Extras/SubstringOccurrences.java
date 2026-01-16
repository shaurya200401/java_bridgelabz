package String.Extras;

import java.util.Scanner;

/*
 * Program: Count Substring Occurrences
 * Purpose: Counts how many times a substring appears within a main string.
 */
public class SubstringOccurrences {

    // Method to count occurrences
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int fromIndex = 0;

        // Loop to find all instances
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            count++;
            fromIndex += sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter main string: ");
        String str = sc.nextLine();
        System.out.print("Enter substring: ");
        String sub = sc.nextLine();

        // Display count
        int count = countOccurrences(str, sub);
        System.out.println("Occurrences: " + count);
        sc.close();
    }
}
