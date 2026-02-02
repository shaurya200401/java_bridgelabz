package javaIOStreams;

/*
 * Program 4: Serialization - Save and Retrieve an Object
 * Stores a list of employees in a file using Object Serialization.
 * Retrieves data using Object Deserialization.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {

    // Employee class must implement Serializable
    // Made static inner class to avoid extra class file issues in package
    public static class Employee implements Serializable {
        private static final long serialVersionUID = 1L; // Recommended for Serializable classes

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
        }
    }

    public static void main(String[] args) {
        String filename = "employees.ser";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 75000));
        employees.add(new Employee(103, "Charlie", "Finance", 60000));

        // Serialization
        serializeEmployees(employees, filename);

        // Deserialization
        deserializeEmployees(filename);
    }

    private static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Serialization successful. Employees saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void deserializeEmployees(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> loadedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : loadedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
