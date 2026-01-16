package CoreProgramming.String.lvl3;

import java.util.Scanner;
import java.util.Calendar;

// Program to display calendar for a specific month and year
public class CalendarDisplay {

    // Method to get month name
    public static String getMonthName(int month) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to get days in month
    public static int getDaysInMonth(int month, int year) {
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        // Leap year check
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Gregorian calendar algorithm to find day of week
    // y0 = y - (14 - m) / 12
    // x = y0 + y0/4 - y0/100 + y0/400
    // m0 = m + 12 * ((14 - m) / 12) - 2
    // d0 = (d + x + 31 * m0 / 12) % 7
    public static int getDayOfWeek(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ...
    }

    public static void displayCalendar(int month, int year) {
        int startDay = getDayOfWeek(1, month, year);
        int daysInMonth = getDaysInMonth(month, year);

        System.out.println("   " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print Initial space
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        displayCalendar(month, year);

        scanner.close();
    }
}
