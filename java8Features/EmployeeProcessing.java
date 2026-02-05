package java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 1: Employee Data Processing
 * Operations: Filter, Sort, Group, Aggregate.
 */
public class EmployeeProcessing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "Engineering", 85000),
                new Employee(2, "Sarah", "HR", 60000),
                new Employee(3, "Mike", "Engineering", 90000),
                new Employee(4, "Emily", "Finance", 75000),
                new Employee(5, "David", "Engineering", 75000),
                new Employee(6, "Anna", "HR", 65000));

        System.out.println("--- 1. Filter: Engineering & Salary > $80,000 ---");
        List<Employee> highPaidEngineers = employees.stream()
                .filter(e -> "Engineering".equals(e.getDepartment()) && e.getSalary() > 80000)
                .collect(Collectors.toList());
        highPaidEngineers.forEach(System.out::println);

        System.out.println("\n--- 2. Sort: By Salary Descending ---");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("\n--- 3. Group: By Department ---");
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        byDept.forEach((dept, list) -> {
            System.out.println(dept + ":");
            list.forEach(e -> System.out.println("  " + e));
        });

        System.out.println("\n--- 4. Aggregate: Average Salary by Department ---");
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        avgSalaryByDept.forEach((dept, avg) -> System.out.printf("%s: $%.2f%n", dept, avg));
    }
}
