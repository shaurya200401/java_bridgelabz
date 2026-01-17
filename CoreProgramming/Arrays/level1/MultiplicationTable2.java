package Arrays.level1;

import java.util.Scanner;

/*
 * Program: Multiplication Table (6-9 Range)
 * Purpose: Displays multiplication table for a number if it is between 6 and 9.
 */
public class MultiplicationTable2 {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 6 and 9: ");
        int number = sc.nextInt();

        // Validate range
        if (number < 6 || number > 9) {
            System.out.println("Invalid input! Please enter a number between 6 and 9.");
        } else {
            int[] multiplicationResult = new int[10];

            for (int i = 1; i <= 10; i++) {
                multiplicationResult[i - 1] = number * i;
            }

            System.out.println("\nMultiplication Table of " + number + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " * " + i + " = " + multiplicationResult[i - 1]);
            }
        }
        sc.close();
    }
}
