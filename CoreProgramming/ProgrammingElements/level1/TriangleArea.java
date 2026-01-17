package ProgrammingElements.level1;

import java.util.Scanner;

/*
 * Program: Triangle Area Calculator
 * Purpose: Calculates the area of a triangle in square cm and square inches given base and height.
 */
public class TriangleArea {
    public static void main(String[] args) {
        // Take input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();

        // Calculate area
        double areaCm2 = 0.5 * base * height;
        double areaInches2 = areaCm2 / 6.4516;
        System.out.println("Area in square cm: " + areaCm2 + " and in square inches: " + areaInches2);
        input.close();
    }

}
