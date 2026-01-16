package OOPFundamentals.level1;

import java.util.Scanner;

/*
 * Program: Area and Circumference of Circle
 * Purpose: Defines a Circle class to calculate and display area and circumference given a radius.
 */
public class Circle {
    // Attribute for radius
    double radius;

    // Constructor to initialize Circle with radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate Area
    public void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.printf("Area of Circle: %.2f%n", area);
    }

    // Method to calculate Circumference
    public void calculateCircumference() {
        double circumference = 2 * Math.PI * radius;
        System.out.printf("Circumference of Circle: %.2f%n", circumference);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user input
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        // Create object and calculations
        Circle circle = new Circle(r);
        circle.calculateArea();
        circle.calculateCircumference();

        sc.close();
    }
}
