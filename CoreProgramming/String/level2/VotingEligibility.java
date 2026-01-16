package String.level2;

import java.util.Scanner;

/*
 * Program: Voting Eligibility Checker
 * Purpose: Generates random ages and checks if each person is eligible to vote (>= 18).
 */
public class VotingEligibility {

    // Generates random ages
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    // Checks eligibility (Age >= 18)
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                results[i][1] = "false";
            } else if (ages[i] >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }
        return results;
    }

    // Displays table
    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Generating random ages for 10 students and checking voting eligibility...");
        int[] ages = generateAges(10);
        String[][] eligibility = checkVotingEligibility(ages);
        displayTable(eligibility);

        scanner.close();
    }
}
