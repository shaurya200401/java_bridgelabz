package OOPFundamentals.level1;

/*
 * Program: Employee Details
 * Purpose: Defines an Employee class with attributes (name, id, salary) and a method to display them.
 */
public class Employee {
    // Attributes to store employee details
    String name;
    int id;
    double salary;

    // Constructor to initialize the Employee object
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display the employee's details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        // Create an Employee instance
        Employee emp = new Employee("John Doe", 101, 50000.0);
        // Call display method
        emp.displayDetails();
    }
}
