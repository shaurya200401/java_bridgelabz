package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Spring Season Checker
 * Purpose: Determines if a given date falls within the Spring season (March 20 to June 20).
 */
public class spring {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter month: ");
        int month = sc.nextInt();
        System.out.print("Enter day: ");
        int day = sc.nextInt();

        // Check for Spring season
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        sc.close();
    }
}
