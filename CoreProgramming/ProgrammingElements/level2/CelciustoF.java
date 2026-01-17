package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Celsius to Fahrenheit Converter
 * Purpose: Converts temperature from Celsius to Fahrenheit using the formula (C * 9/5) + 32.
 */
public class CelciustoF {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        // Convert to Fahrenheit
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("The " + celsius + " Celsius is " + fahrenheit + " Fahrenheit");
        sc.close();
    }

}
