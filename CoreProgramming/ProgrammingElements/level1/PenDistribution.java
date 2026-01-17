package ProgrammingElements.level1;

/*
 * Program: Pen Distribution
 * Purpose: Calculates how many pens each student gets and the remainder.
 */
public class PenDistribution {
    public static void main(String[] args) {
        // Initialize values
        int pens = 14, students = 3;

        // Calculate distribution and remainder
        int perStudent = pens / students;
        int remaining = pens % students;
        System.out.println(
                "The Pen Per Student is " + perStudent + " and the remaining pen not distributed is " + remaining);
    }

}
