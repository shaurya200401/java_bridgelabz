package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Weight Converter
 * Purpose: Converts weight from pounds to kilograms.
 */
public class poundkg {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();

        // Convert to Kg
        double kilograms = pounds / 2.2;
        System.out.println("The weight of the person in pound is " + pounds + " and in kg is " + kilograms);
        sc.close();
    }

}
