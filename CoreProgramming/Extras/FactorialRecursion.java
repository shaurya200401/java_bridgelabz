package Extras;

import java.util.Scanner;

/*
 * Program: Factorial using Recursion
 * Purpose: Calculates the factorial of a number using a recursive approach.
 */
public class FactorialRecursion {

    // Recursive method to find factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Check for negative input
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(num);
            System.out.println("Factorial of " + num + " is " + result);
        }
        sc.close();
    }
}
