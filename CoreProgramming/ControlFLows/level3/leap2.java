package ControlFLows.level3;

import java.util.Scanner;

/*
 * Program: Leap Year Checker (Single Condition)
 * Purpose: Checks if a year is a leap year using a single complex boolean expression.
 */
public class leap2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        // Single if condition using && (AND) and || (OR) for leap year check
        if ((year >= 1582) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year (or is pre-1582).");
        }
        sc.close();
    }
}
