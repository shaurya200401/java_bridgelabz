package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Quotient and Remainder Calculator
 * Purpose: Calculates the quotient and remainder when one number is divided by another.
 */
public class quotientrem {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        // Calculate quotient and remainder
        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder +
                " of two numbers " + number1 + " and " + number2);
        sc.close();
    }

}
