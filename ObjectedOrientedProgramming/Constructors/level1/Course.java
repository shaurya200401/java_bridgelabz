package Constructors.level1;
/*
 * Course Class
 * Demonstrates the use of static variables for common data (instituteName).
 * Allows updating the institute name for all courses.
 */
public class Course {
    String courseName;
    int duration; // in months
    double fee;
    static String instituteName = "Tech Academy"; // Common for all courses

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName + ", Course: " + courseName + ", Duration: " + duration
                + " months, Fee: $" + fee);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Web Development", 6, 500);
        Course c2 = new Course("Data Science", 8, 800);

        System.out.println("Before Update:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name
        Course.updateInstituteName("Global Tech Institute");

        System.out.println("\nAfter Update:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
