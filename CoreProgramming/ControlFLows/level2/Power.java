package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Power Calculator
 * Purpose: Calculates the value of a base number raised to a positive exponent using a for loop.
 */
public class Power {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        System.out.print("Enter power: ");
        int power = sc.nextInt();

        // Calculate power
        if (number > 0 && power >= 0) {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + "^" + power + " = " + result);
        } else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}
