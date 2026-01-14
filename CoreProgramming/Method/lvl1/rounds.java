package Method.lvl1;

import java.util.Scanner;

public class rounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of the triangle (meters): ");
        double s1 = sc.nextDouble(), s2 = sc.nextDouble(), s3 = sc.nextDouble();

        double rounds = calculateRounds(s1, s2, s3);
        System.out.printf("Rounds required to complete 5km: %.2f\n", rounds);
    }

    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000.0 / perimeter; // 5km = 5000m
    }
}