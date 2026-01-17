package ProgrammingElements.level1;

import java.util.Scanner;

/*
 * Program: Height Converter
 * Purpose: Converts height from centimeters to feet and inches.
 */
public class MtoFeet {
    public static void main(String[] args) {
        // Take input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter height in cm: ");
        double cm = input.nextDouble();

        // Convert to inches and feet
        double inches = cm / 2.54;
        double feet = inches / 12;
        System.out.println("Your Height in cm is " + cm + " while in feet is " + feet + " and inches is " + inches);
        input.close();
    }

}
