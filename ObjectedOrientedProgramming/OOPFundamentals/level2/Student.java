package OOPFundamentals.level2;

/*
 * Program: Student Report Simulator
 * Purpose: Defines a Student class to calculate grades based on marks and display a report.
 */
public class Student {
    // Student data attributes
    String name;
    int rollNumber;
    double marks;

    // Constructor to initialize Student
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to determine grade
    public String calculateGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 80)
            return "B";
        else if (marks >= 70)
            return "C";
        else if (marks >= 60)
            return "D";
        else
            return "F";
    }

    // Method to display full report
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        // Create object and display
        Student s1 = new Student("Alice", 101, 85.5);
        s1.displayDetails();
    }
}
