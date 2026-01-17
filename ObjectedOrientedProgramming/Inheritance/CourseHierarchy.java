package ObjectedOrientedProgramming.Inheritance;

/*
 * CourseHierarchy Class
 * Demonstrates multilevel inheritance complexity building.
 * Hierarchy: Course -> OnlineCourse -> PaidOnlineCourse.
 */

public class CourseHierarchy {

    static class Course {
        String courseName;
        int durationHours;

        public Course(String courseName, int durationHours) {
            this.courseName = courseName;
            this.durationHours = durationHours;
        }

        public void displayDetails() {
            System.out.println("Course: " + courseName + ", Duration: " + durationHours + " hours");
        }
    }

    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        public OnlineCourse(String courseName, int durationHours, String platform, boolean isRecorded) {
            super(courseName, durationHours);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }

        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        public PaidOnlineCourse(String courseName, int durationHours, String platform, boolean isRecorded, double fee,
                double discount) {
            super(courseName, durationHours, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Fee: $" + fee + ", Discount: " + discount + "%");
            System.out.println("Final Price: $" + (fee - (fee * discount / 100)));
        }
    }

    public static void main(String[] args) {
        PaidOnlineCourse javaCourse = new PaidOnlineCourse("Java Mastery", 40, "Udemy", true, 100.0, 10.0);
        javaCourse.displayDetails();
    }
}
