package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Factor Finder
 * Purpose: Finds and prints all factors of a user-inputted positive integer using a for loop.
 */
public class Factors {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Find factors
        if (number > 0) {
            for (int i = 1; i < number; i++) {
                if (number % i == 0)
                    System.out.println(i);
            }
        } else {
            System.out.println("Not a positive integer");
        }
        sc.close();
    }
}
