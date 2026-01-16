package Extras;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
 * Program: Date Arithmetic
 * Purpose: Demonstrates adding/subtracting days, months, and years from a date.
 */
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read date input
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        // Parse input to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);

        System.out.println("Original Date: " + date);

        // Add 7 days, 1 month, 2 years
        LocalDate futureDate = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, 2 years: " + futureDate);

        // Subtract 3 weeks
        LocalDate finalDate = futureDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);

        sc.close();
    }
}
