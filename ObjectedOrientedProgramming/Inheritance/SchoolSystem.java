package ObjectedOrientedProgramming.Inheritance;

/*
 * SchoolSystem Class
 * Demonstrates hierarchical inheritance where Person is the superclass.
 * Subclasses: Teacher, Student, and Staff with specific attributes.
 */

public class SchoolSystem {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void displayRole() {
            System.out.println("Role: General Person");
        }

        public void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    static class Teacher extends Person {
        String subject;

        public Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        @Override
        public void displayRole() {
            System.out.println("Role: Teacher (Subject: " + subject + ")");
        }
    }

    static class Student extends Person {
        String grade;

        public Student(String name, int age, String grade) {
            super(name, age);
            this.grade = grade;
        }

        @Override
        public void displayRole() {
            System.out.println("Role: Student (Grade: " + grade + ")");
        }
    }

    static class Staff extends Person {
        String department;

        public Staff(String name, int age, String department) {
            super(name, age);
            this.department = department;
        }

        @Override
        public void displayRole() {
            System.out.println("Role: Staff (Department: " + department + ")");
        }
    }

    public static void main(String[] args) {
        Person teacher = new Teacher("Mr. Smith", 40, "Mathematics");
        Person student = new Student("Alice", 14, "9th");
        Person staff = new Staff("Bob", 35, "Maintenance");

        Person[] people = { teacher, student, staff };

        for (Person p : people) {
            p.displayInfo();
            p.displayRole();
            System.out.println("-----------------");
        }
    }
}
