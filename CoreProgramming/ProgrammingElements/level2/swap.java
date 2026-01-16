package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Number Swapper
 * Purpose: Swaps two numbers using a temporary variable.
 */
public class swap {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int number1 = sc.nextInt();
        System.out.print("Enter number2: ");
        int number2 = sc.nextInt();

        // Swap logic
        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("The swapped numbers are " + number1 + " and " + number2);
        sc.close();
    }

}
