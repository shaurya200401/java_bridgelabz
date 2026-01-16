package String.level2;

import java.util.Scanner;

/*
 * Program: Student Grade Calculator
 * Purpose: Generates random scores, calculates averages and grades, and displays a scorecard.
 */
public class StudentGrades {

    // Generates random 2-digit scores for Physics, Chemistry, and Math for n
    // students
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            // Random marks between 10 and 99
            scores[i][0] = 10 + (int) (Math.random() * 90); // Physics
            scores[i][1] = 10 + (int) (Math.random() * 90); // Chemistry
            scores[i][2] = 10 + (int) (Math.random() * 90); // Maths
        }
        return scores;
    }

    // Calculates Total, Average, and Percentage for each student
    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0; // Keep precision
            double percentage = (total / 300.0) * 100;

            // Round off to 2 digits using Math.round
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    // Calculates Grade based on percentage
    public static String[][] calculateGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];

            if (percentage >= 80)
                grades[i][0] = "A";
            else if (percentage >= 70)
                grades[i][0] = "B";
            else if (percentage >= 60)
                grades[i][0] = "C";
            else if (percentage >= 50)
                grades[i][0] = "D";
            else if (percentage >= 40)
                grades[i][0] = "E";
            else
                grades[i][0] = "R";
        }
        return grades;
    }

    // Displays the scorecard in tabular format
    public static void displayScorecard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("\n--- Student Scorecard ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-10s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-10s%n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2], stats[i][0], stats[i][1], stats[i][2],
                    grades[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();

        // 1. Generate Scores
        int[][] scores = generateScores(n);

        // 2. Calculate Stats
        double[][] stats = calculateStats(scores);

        // 3. Calculate Grades
        String[][] grades = calculateGrades(stats);

        // 4. Display Scorecard
        displayScorecard(scores, stats, grades);

        scanner.close();
    }
}
