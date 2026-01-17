package Method.level1;

import java.util.Scanner;

/*
 * Program: Natural Number Sum Calculator
 * Purpose: Calculates the sum of the first N natural numbers using a loop inside a method.
 */
public class NaturalNum {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        // Calculate sum
        System.out.println("Sum of " + n + " natural numbers: " + findSum(n));
        sc.close();
    }

    public static int findSum(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++)
            total += i;
        return total;
    }
}
