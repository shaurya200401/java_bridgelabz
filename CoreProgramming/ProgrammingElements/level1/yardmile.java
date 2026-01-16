package ProgrammingElements.level1;

import java.util.Scanner;

/*
 * Program: Distance Converter
 * Purpose: Converts distance from feet to yards and miles.
 */
public class yardmile {
    public static void main(String[] args) {
        // Take input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();

        // Convert to yards and miles
        double yards = feet / 3;
        double miles = yards / 1760;
        System.out.println("Distance in yards: " + yards + " and in miles: " + miles);
        input.close();
    }

}
