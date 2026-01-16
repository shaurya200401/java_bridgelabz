package ControlFLows.level3;

import java.util.Scanner;

/*
 * Program: Student Grading System
 * Purpose: Calculates average marks and assigns a grade/remark based on Physics, Chemistry, and Maths scores.
 */
public class grade {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Physics, Chemistry, and Maths marks: ");
        double p = sc.nextDouble(), c = sc.nextDouble(), m = sc.nextDouble();

        // Calculate grade
        double avg = (p + c + m) / 3.0;
        String grade, remark;

        if (avg >= 80) {
            grade = "A";
            remark = "Level 4, above agency-normalized standards";
        } else if (avg >= 70) {
            grade = "B";
            remark = "Level 3, at agency-normalized standards";
        } else if (avg >= 60) {
            grade = "C";
            remark = "Level 2, below, but approaching standards";
        } else if (avg >= 50) {
            grade = "D";
            remark = "Level 1, well below standards";
        } else if (avg >= 40) {
            grade = "E";
            remark = "Level 1-, too below standards";
        } else {
            grade = "R";
            remark = "Remedial standards";
        }

        System.out.printf("Average: %.2f%% | Grade: %s | Remark: %s\n", avg, grade, remark);
        sc.close();
    }
}
