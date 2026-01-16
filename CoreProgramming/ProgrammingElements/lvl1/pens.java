package ProgrammingElements.lvl1;

public class pens {
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
