package Operators.level1;

/*
 * Student Class
 * Manages university student data.
 * Includes static university name and final roll number.
 */
public class Student {
    static String universityName = "Prestige University"; // Shared utility
    static int totalStudents = 0;

    final int rollNumber; // Immutable roll number
    String name;
    String grade;

    // Constructor
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Student s1 = new Student(2023001, "Emma Watson", "A");

        // Instanceof check
        if (s1 instanceof Student) {
            s1.displayStudentDetails();
        }

        Student.displayTotalStudents();
    }
}
