package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 7. Sort CSV Records by a Column
 * Reads a CSV file and sorts the records by Salary in descending order.
 * Prints the top 5 highest-paid employees.
 */
public class SortCSV {
    static class Employee {
        String id;
        String name;
        String department;
        double salary;

        public Employee(String id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
        }
    }

    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    try {
                        double salary = Double.parseDouble(columns[3].trim());
                        employees.add(new Employee(columns[0], columns[1], columns[2], salary));
                    } catch (NumberFormatException e) {
                        // Skip invalid records
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by salary descending
        Collections.sort(employees, Comparator.comparingDouble((Employee e) -> e.salary).reversed());

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i));
        }
    }
}
