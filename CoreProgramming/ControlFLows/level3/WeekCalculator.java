package ControlFLows.level3;

/*
 * Program: Day of Week Calculator
 * Purpose: Calculates the day of the week (0=Sunday, 1=Monday, etc.) for a given date using formula.
 * Usage: Provide month, day, and year as command-line arguments.
 */
public class WeekCalculator {
    public static void main(String[] args) {
        // Taking input from command-line arguments as requested (month, day, year)
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // Calculate day of week logic

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;

        System.out.println("Day of the week index: " + d0);
        // 0=Sunday, 1=Monday...
    }
}
