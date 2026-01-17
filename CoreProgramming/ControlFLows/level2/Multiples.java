package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Multiple Finder (Under 100)
 * Purpose: Finds and prints multiples of a given number (less than 100) backwards from 100 to 1.
 */
public class Multiples {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        // Find multiples logic
        if (number > 0 && number < 100) {
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0)
                    System.out.println(i);
            }
        } else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}
