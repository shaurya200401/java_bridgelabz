package Method.level3;

import java.util.Scanner;

/*
 * Program: Euclidean Distance and Line Equation
 * Purpose: Calculates the Euclidean distance between two points and finds the equation of the line connecting them (y = mx + b).
 */
public class LineEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        // Calculate Euclidean distance
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Calculate line equation y = mx + b
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;

        System.out.println("Distance: " + distance);
        System.out.println("Equation: y = " + m + "x + " + b);
        sc.close();
    }
}
