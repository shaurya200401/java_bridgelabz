package ProgrammingElements.level1;

/*
 * Program: Average Marks Calculator
 * Purpose: Calculates the average marks of a student in PCM (Physics, Chemistry, Math).
 */
public class AvgMarks {
    public static void main(String[] args) {
        // Initialize marks
        int maths = 94, physics = 95, chemistry = 96;

        // Calculate average
        double average = (maths + physics + chemistry) / 3.0;
        System.out.println("Sam's average mark in PCM is " + average);
    }
}
