package Constructors.level1;
/*
 * Student Class
 * Demonstrates access modifiers: public, protected, and private.
 * Includes a subclass PostgraduateStudent to show access inheritance.
 */
public class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public static void main(String[] args) {
        Student s = new Student(101, "John", 8.5);
        System.out.println("Roll Number (Public): " + s.rollNumber); // Accessible
        System.out.println("Name (Protected): " + s.name); // Accessible in same package
        // System.out.println("CGPA: " + s.cgpa); // Error: private access
        System.out.println("CGPA (via Getter): " + s.getCgpa());

        PostgraduateStudent pg = new PostgraduateStudent(102, "Alice", 9.0);
        pg.showDetails();
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    public void showDetails() {
        System.out.println("PG Student Details:");
        System.out.println("Roll Number: " + rollNumber); // Public: Accessible
        System.out.println("Name: " + name); // Protected: Accessible in subclass
        // System.out.println("CGPA: " + cgpa); // Private: Not accessible directly
        System.out.println("CGPA: " + getCgpa()); // Accessed via public method
    }
}
