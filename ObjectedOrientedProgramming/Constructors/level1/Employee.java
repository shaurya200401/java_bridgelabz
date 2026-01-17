package Constructors.level1;
/*
 * Employee Class
 * Demonstrates access modifiers in an employee record system.
 * EmployeeID (public), Department (protected), Salary (private).
 */
class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(101, "IT", 75000);
        mgr.showManagerDetails();
        mgr.setSalary(80000); // Accessing private salary via public method
        System.out.println("Updated Salary: " + mgr.getSalary());
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showManagerDetails() {
        System.out.println("Manager ID: " + employeeID); // Public
        System.out.println("Department: " + department); // Protected
        // System.out.println("Salary: " + salary); // Private: Not accessible
    }
}
