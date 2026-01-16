package Extras;

import java.util.Scanner;

/*
 * Program: Prime Number Checker
 * Purpose: Determines if a given integer is a prime number.
 */
public class PrimeChecker {

    // Method to check primality
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        // Check for factors up to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Result display
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
        sc.close();
    }
}
