package Method.level1;

import java.util.Scanner;

/*
 * Program: Wind Chill Calculator
 * Purpose: Calculates wind chill temperature given air temperature (F) and wind speed (mph).
 */
public class WindChill {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (F) and wind speed (mph): ");
        double t = sc.nextDouble(), v = sc.nextDouble();

        // Calculate wind chill
        WindChill obj = new WindChill();
        System.out.printf("Wind Chill Temperature: %.2f\n", obj.calculateWindChill(t, v));
        sc.close();
    }

    public double calculateWindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
    }
}
