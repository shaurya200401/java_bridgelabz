package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Fahrenheit to Celsius Converter
 * Purpose: Converts temperature from Fahrenheit to Celsius using formula (F - 32) * 5/9.
 */
public class ftoc {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();

        // Convert to Celsius
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsius + " Celsius");
        sc.close();
    }

}
