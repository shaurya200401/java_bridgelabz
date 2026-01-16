package Method.level2;

/*
 * Program: Leap Year Check (Method)
 * Purpose: Determines if a given year is a leap year using a boolean method.
 */
public class leapyear {
    public static boolean isLeapYear(int year) {
        // Leap year logic
        if (year < 1582)
            return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        int year = 2024;
        System.out.println(year + " is Leap Year: " + isLeapYear(year));
    }
}
