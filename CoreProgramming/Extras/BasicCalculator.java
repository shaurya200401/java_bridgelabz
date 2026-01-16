package Extras;

import java.util.Scanner;

/*
 * Program: Basic Calculator
 * Purpose: Performs basic arithmetic operations (addition, subtraction, multiplication, division).
 */
public class BasicCalculator {

    // Method to add two numbers
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to subtract two numbers
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method to multiply two numbers
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method to divide two numbers with zero check
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Basic Calculator");

        // Input numbers
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        // Input operation
        System.out.println("Choose operation: +, -, *, /");
        char operator = sc.next().charAt(0);

        double result = 0;
        // Perform operation based on input
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operator");
                sc.close();
                return;
        }

        // Display result if valid
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }
        sc.close();
    }
}
