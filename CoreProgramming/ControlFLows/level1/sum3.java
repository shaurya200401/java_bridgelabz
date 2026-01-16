package ControlFLows.level1;

import java.util.Scanner;

public class sum3 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a natural number: ");
        int m = sc.nextInt();

        // Calculate sum
        if (m >= 0) {
            int sumFormula = m * (m + 1) / 2;
            int sumWhile = 0, i = 1;
            while (i <= m) {
                sumWhile += i;
                i++;
            }
            System.out.println("Formula result: " + sumFormula);
            System.out.println("While loop result: " + sumWhile);
        } else {
            System.out.println("Not a natural number");
        }

    }
}
