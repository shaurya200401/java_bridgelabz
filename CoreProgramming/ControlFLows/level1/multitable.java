package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Multiplication Table (6-9)
 * Purpose: Prints the multiplication table for a number multiplied by 6, 7, 8, and 9.
 */
public class multitable {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number: ");
        int tableNum = sc.nextInt();

        // Print multiplication table
        for (int i = 6; i <= 9; i++) {
            System.out.println(tableNum + " * " + i + " = " + (tableNum * i));
        }

        sc.close();
    }
}
