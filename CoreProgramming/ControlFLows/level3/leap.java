package ControlFLows.level3;

import java.util.Scanner;

public class leap {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year (>= 1582): ");
        int year = sc.nextInt();

        // Check leap year logic
        if (year < 1582) {
            System.out.println("Year must be 1582 or later.");
        } else {
            // Single if statement using logical operators as per Hint 2
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        }
    }
}
