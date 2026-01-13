package ControlFLows.lvl3;
import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number, second number, and operator (+, -, *, /): ");
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();

        switch (op) {
            case "+": System.out.println("Result: " + (first + second)); break;
            case "-": System.out.println("Result: " + (first - second)); break;
            case "*": System.out.println("Result: " + (first * second)); break;
            case "/":
                if (second != 0) System.out.println("Result: " + (first / second));
                else System.out.println("Error: Division by zero");
                break;
            default: System.out.println("Invalid Operator");
        }
    }
}