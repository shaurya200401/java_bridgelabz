package ControlFLows.level3;

import java.util.Scanner;

/*
 * Program: Armstrong Number Checker
 * Purpose: Checks if a number is an Armstrong number (sum of cubes of digits equals the number).
 */
public class armstr {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        int originalNumber = number;
        int sum = 0;

        // Calculate armstrong number logic
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += (digit * digit * digit);
            originalNumber /= 10;
        }

        if (sum == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
        sc.close();
    }
}
