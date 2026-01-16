package ControlFLows.level1;

import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a positive integer: ");
        int factNum2 = sc.nextInt();

        // Calculate factorial using for loop
        if (factNum2 >= 0) {
            int fact = 1;
            for (int i = 1; i <= factNum2; i++) {
                fact *= i;
            }
            System.out.println("Factorial of " + factNum2 + " is " + fact);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
