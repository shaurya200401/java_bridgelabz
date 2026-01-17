package ControlFLows.level2;

import java.util.Scanner;

/*
 * Program: Multiplication Table Range
 * Purpose: Prints the multiplication table of a number for multiples 6 through 9.
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Print multiplication table
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        sc.close();
    }
}
