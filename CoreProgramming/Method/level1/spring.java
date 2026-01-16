package Method.level1;

/*
 * Program: Spring Season Checker
 * Purpose: Determines if a given month and day correspond to the Spring season.
 * Usage: Provide month and day as command-line arguments.
 */
public class spring {
    public static void main(String[] args) {
        // Read arguments
        if (args.length < 2) {
            System.out.println("Please provide month and day as arguments.");
            return;
        }
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if spring season
        if (isSpring(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    public static boolean isSpring(int m, int d) {
        return (m == 3 && d >= 20 && d <= 31) ||
                (m == 4 && d >= 1 && d <= 30) ||
                (m == 5 && d >= 1 && d <= 31) ||
                (m == 6 && d >= 1 && d <= 20);
    }
}
