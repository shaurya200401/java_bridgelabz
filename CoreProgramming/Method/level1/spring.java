package Method.lvl1;

public class spring {
    public static void main(String[] args) {
        // Read arguments
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