package Method.level1;

import java.util.Scanner;

/*
 * Program: Track Rounds Calculator
 * Purpose: Calculates the number of rounds required to cover 5km based on the perimeter of a triangular track.
 */
public class Rounds {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of the triangle (meters): ");
        double s1 = sc.nextDouble(), s2 = sc.nextDouble(), s3 = sc.nextDouble();

        // Calculate rounds
        double rounds = calculateRounds(s1, s2, s3);
        System.out.printf("Rounds required to complete 5km: %.2f\n", rounds);
        sc.close();
    }

    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000.0 / perimeter; // 5km = 5000m
    }
}
