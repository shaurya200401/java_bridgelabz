package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Simple Interest Calculator
 * Purpose: Calculates the simple interest using the formula (P * R * T) / 100 based on user input.
 */
public class SI {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();

        // Calculate SI
        double si = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + si + " for Principal " + principal +
                ", Rate of Interest " + rate + " and Time " + time);
        sc.close();
    }

}
