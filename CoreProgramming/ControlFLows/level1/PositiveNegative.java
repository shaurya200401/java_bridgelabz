package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Positive or Negative Checker
 * Purpose: Determines if a given number is positive, negative, or zero.
 */
public class PositiveNegative {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number: ");
        int num = sc.nextInt();

        // Check positive/negative
        if (num > 0)
            System.out.println("Positive");
        else if (num < 0)
            System.out.println("Negative");
        else
            System.out.println("Zero");

        sc.close();
    }
}
