package Method.level1;

import java.util.Scanner;

public class si {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal, Rate, and Time: ");
        double p = sc.nextDouble(), r = sc.nextDouble(), t = sc.nextDouble();

        // Calculate SI
        double si = calculateSI(p, r, t);
        System.out.println("The Simple Interest is " + si + " for Principal " + p +
                ", Rate of Interest " + r + " and Time " + t);
    }

    public static double calculateSI(double p, double r, double t) {
        return (p * r * t) / 100;
    }
}
