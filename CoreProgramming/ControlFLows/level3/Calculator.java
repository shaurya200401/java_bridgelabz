package ControlFLows.level3;

import java.util.Scanner;

/*
 * Program: Simple Calculator
 * Purpose: Performs basic arithmetic operations (+, -, *, /) on two numbers based on user input.
 */
public class Calculator {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number, second number, and operator (+, -, *, /): ");
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();

        // Perform calculation
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0)
                    System.out.println("Result: " + (first / second));
                else
                    System.out.println("Error: Division by zero");
                break;
            default:
                System.out.println("Invalid Operator");
        }
        sc.close();
    }
}
