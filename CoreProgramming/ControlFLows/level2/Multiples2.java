package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Multiple Finder (While Loop)
 * Purpose: Finds multiples of a number (less than 100) iterating backwards from 100 using a while loop.
 */
public class Multiples2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        // Find multiples using while loop
        if (number > 0 && number < 100) {
            int i = 100;
            while (i >= 1) {
                if (i % number == 0) {
                    System.out.println(i);
                }
                i--;
            }
        } else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}
