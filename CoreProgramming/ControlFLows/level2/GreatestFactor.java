package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Greatest Factor Finder
 * Purpose: Finds the greatest factor of a given number (excluding the number itself) using a loop descending from N-1.
 */
public class GreatestFactor {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Find greatest factor
        int greatestFactor = 1;
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        System.out.println("Greatest factor (besides itself) = " + greatestFactor);
        sc.close();
    }
}
