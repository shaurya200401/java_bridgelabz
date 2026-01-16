package ControlFLows.level3;

import java.util.Scanner;

/*
 * Program: Prime Number Checker
 * Purpose: Checks if a given number is prime by testing divisibility from 2 up to num/2.
 */
public class prime {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        boolean isPrime = num > 1;

        // Check prime logic
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(num + (isPrime ? " is a prime number." : " is not a prime number."));
        sc.close();
    }
}
