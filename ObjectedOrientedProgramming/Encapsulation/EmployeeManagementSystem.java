package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * EmployeeManagementSystem Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * Employee is the abstract superclass; FullTimeEmployee and PartTimeEmployee are subclasses.
 * Department is an interface.
 */
public class EmployeeManagementSystem {

    interface Department {
        void assignDepartment(String departmentName);

        String getDepartmentDetails();
    }

    static abstract class Employee implements Department {
        private int employeeId;
        private String name;
        private double baseSalary;
        private String departmentName;

        public Employee(int employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }

        @Override
        public void assignDepartment(String departmentName) {
            this.departmentName = departmentName;
        }

        @Override
        public String getDepartmentDetails() {
            return departmentName;
        }

        public abstract double calculateSalary();

        public void displayDetails() {
            System.out.println("ID: " + employeeId);
            System.out.println("Name: " + name);
            System.out.println("Department: " + departmentName);
            System.out.println("Base Salary: $" + baseSalary);
            System.out.println("Total Salary: $" + calculateSalary());
        }
    }

    static class FullTimeEmployee extends Employee {
        private double bonus;

        public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
            super(employeeId, name, baseSalary);
            this.bonus = bonus;
        }

        public double getBonus() {
            return bonus;
        }

        public void setBonus(double bonus) {
            this.bonus = bonus;
        }

        @Override
        public double calculateSalary() {
            return getBaseSalary() + bonus;
        }
    }

    static class PartTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
            super(employeeId, name, 0); // Base salary is 0 for part-time
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        public int getHoursWorked() {
            return hoursWorked;
        }

        public void setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
        }

        public double getHourlyRate() {
            return hourlyRate;
        }

        public void setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 5000, 1000);
        emp1.assignDepartment("IT");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 50);
        emp2.assignDepartment("Support");

        employees.add(emp1);
        employees.add(emp2);

        System.out.println("Employee Details:");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("-------------------------");
        }
    }
}
