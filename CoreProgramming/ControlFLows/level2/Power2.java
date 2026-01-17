package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Power Calculator (While Loop)
 * Purpose: Calculates the value of a base number raised to a positive exponent using a while loop.
 */
public class Power2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        System.out.print("Enter power: ");
        int power = sc.nextInt();

        // Calculate power using while loop
        if (number > 0 && power >= 0) {
            int result = 1;
            int counter = 0;
            while (counter < power) {
                result *= number;
                counter++;
            }
            System.out.println(number + "^" + power + " = " + result);
        } else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}
