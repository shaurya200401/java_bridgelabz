package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Sum Calculator (Until 0)
 * Purpose: Continuously adds numbers entered by the user until 0 is entered.
 */
public class Sum {
    public static void main(String[] args) {
        // Calculate sum
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("\nEnter a number (0 to stop): ");
            double val = sc.nextDouble();
            if (val == 0)
                break;
            total += val;
        }
        System.out.println("Total sum = " + total);
        sc.close();
    }
}
