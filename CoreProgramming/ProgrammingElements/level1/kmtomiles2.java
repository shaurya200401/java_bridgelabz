package ProgrammingElements.level1;

import java.util.Scanner;

/*
 * Program: Km to Miles Converter (Input)
 * Purpose: Converts a user-input distance in kilometers to miles.
 */
public class kmtomiles2 {
    public static void main(String[] args) {
        // Take input for km
        Scanner input = new Scanner(System.in);
        double km;
        System.out.print("Enter distance in km: ");
        km = input.nextDouble();

        // Convert to miles
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        input.close();
    }

}
