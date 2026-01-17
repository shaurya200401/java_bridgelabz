package Method.level1;

import java.util.Scanner;

/*
 * Program: Trigonometric Functions Calculator
 * Purpose: Calculates Sine, Cosine, and Tangent for a given angle in degrees.
 */
public class TrigonometricFunctions {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        // Calculate trig functions
        TrigonometricFunctions obj = new TrigonometricFunctions();
        double[] results = obj.calculateTrigonometricFunctions(angle);

        System.out.printf("Sine: %.4f, Cosine: %.4f, Tangent: %.4f\n", results[0], results[1], results[2]);
        sc.close();
    }

    public double[] calculateTrigonometricFunctions(double angle) {
        double rad = Math.toRadians(angle);
        return new double[] { Math.sin(rad), Math.cos(rad), Math.tan(rad) };
    }
}
