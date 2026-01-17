package Arrays.level2;

import java.util.Scanner;

/*
 * Program: Student Marks Report
 * Purpose: Generates a report with total marks, percentage, and grades for N students.
 */
public class Marks1 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Initialize arrays
        int[][] marks = new int[n][3]; // [Physics, Chemistry, Maths]
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print("Enter marks for " + subject + ": ");
                int mark = sc.nextInt();

                if (mark < 0) {
                    System.out.println("Marks cannot be negative. Please re-enter.");
                    j--; // retry this subject
                } else {
                    marks[i][j] = mark;
                }
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80)
                grade[i] = "A";
            else if (percentage[i] >= 70)
                grade[i] = "B";
            else if (percentage[i] >= 60)
                grade[i] = "C";
            else if (percentage[i] >= 50)
                grade[i] = "D";
            else if (percentage[i] >= 40)
                grade[i] = "E";
            else
                grade[i] = "R";
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: Physics = %d, Chemistry = %d, Maths = %d, Percentage = %.2f%%, Grade = %s\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
        sc.close();
    }
}
