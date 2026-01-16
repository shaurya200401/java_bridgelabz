package Extras;

import java.util.Scanner;

/*
 * Program: Fibonacci Sequence Generator
 * Purpose: Generates the Fibonacci sequence up to a specified number of terms.
 */
public class FibonacciGenerator {

    // Method to generate and print Fibonacci series
    public static void generateFibonacci(int n) {
        int first = 0, second = 1;
        System.out.print("Fibonacci Sequence: ");

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        // Generate sequence
        generateFibonacci(terms);
        sc.close();
    }
}
