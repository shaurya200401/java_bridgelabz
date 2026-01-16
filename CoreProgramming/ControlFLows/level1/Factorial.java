package ControlFLows.lvl1;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a positive integer: ");
        int factNum = sc.nextInt();

        // Calculate factorial
        if (factNum >= 0) {
            int fact = 1, i = 1;
            while (i <= factNum) {
                fact *= i;
                i++;
            }
            System.out.println("Factorial of " + factNum + " is " + fact);
        } else {
            System.out.println("Not a natural number");
        }

    }
}