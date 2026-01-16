package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Odd or Even Printer
 * Purpose: Iterates from 1 to a given number and prints whether each number is Odd or Even.
 */
public class oddeve {
    public static void main(String[] args) {
        // Read limit
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a natural number: ");
        int limit = sc.nextInt();

        // Check odd/even
        if (limit >= 1) {
            for (int i = 1; i <= limit; i++) {
                if (i % 2 == 0)
                    System.out.println(i + " is Even");
                else
                    System.out.println(i + " is Odd");
            }
        } else {
            System.out.println("Not a natural number");
        }
        sc.close();
    }
}
