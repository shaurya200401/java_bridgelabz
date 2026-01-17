package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Sum of Natural Numbers
 * Purpose: Calculates the sum of the first N natural numbers.
 */
public class NaturalNumber {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Calculate sum of natural numbers
        if (n >= 0) {
            int sum = n * (n + 1) / 2;
            System.out.println("The sum of " + n + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
        sc.close();
    }
}
