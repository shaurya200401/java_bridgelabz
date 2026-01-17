package ObjectedOrientedProgramming.Inheritance;

/*
 * EmployeeSystem Class
 * Demonstrates inheritance by creating subclasses with specific attributes and overriding superclass methods.
 * Employee hierarchy for different employee types such as Manager, Developer, and Intern.
 */

public class EmployeeSystem {

    static class Employee {
        String name;
        int id;
        double salary;

        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        public void displayDetails() {
            System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
        }
    }

    static class Manager extends Employee {
        int teamSize;

        public Manager(String name, int id, double salary, int teamSize) {
            super(name, id, salary);
            this.teamSize = teamSize;
        }

        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Role: Manager, Team Size: " + teamSize);
        }
    }

    static class Developer extends Employee {
        String programmingLanguage;

        public Developer(String name, int id, double salary, String programmingLanguage) {
            super(name, id, salary);
            this.programmingLanguage = programmingLanguage;
        }

        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
        }
    }

    static class Intern extends Employee {
        String university;

        public Intern(String name, int id, double salary, String university) {
            super(name, id, salary);
            this.university = university;
        }

        @Override
        public void displayDetails() {
            super.displayDetails();
            System.out.println("Role: Intern, University: " + university);
        }
    }

    public static void main(String[] args) {
        Manager mgr = new Manager("Alice", 101, 90000, 10);
        Developer dev = new Developer("Bob", 102, 80000, "Java");
        Intern intern = new Intern("Charlie", 103, 30000, "MIT");

        mgr.displayDetails();
        System.out.println();
        dev.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}
