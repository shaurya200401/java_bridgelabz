package Operators.level1;

/*
 * Employee Class
 * Manages employee details with a static company name.
 * Uses final for ID and checks object type with instanceof.
 */
public class Employee {
    static String companyName = "Tech Solutions Ltd."; // Shared company name
    static int totalEmployees = 0;

    final int id; // Immutable ID
    String name;
    String designation;

    // Constructor
    public Employee(int id, String name, String designation) {
        this.id = id; // Initialize final variable
        this.name = name; // Using this
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Company: " + companyName);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "John Smith", "Developer");

        // Instanceof check
        if (emp1 instanceof Employee) {
            System.out.println("Valid Employee Record:");
            emp1.displayDetails();
        }

        Employee.displayTotalEmployees();
    }
}
