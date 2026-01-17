package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Sum Calculator (Until Negative/Zero)
 * Purpose: Adds numbers entered by the user until a negative number or zero is entered.
 */
public class Sum2 {
    public static void main(String[] args) {
        // Calculate sum
        Scanner sc = new Scanner(System.in);
        double total2 = 0.0;
        while (true) {
            System.out.print("\nEnter a number (0 or negative to stop): ");
            double val = sc.nextDouble();
            if (val <= 0)
                break;
            total2 += val;
        }
        System.out.println("Total sum = " + total2);
        sc.close();
    }
}
