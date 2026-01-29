package collectionsFramework.mapInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class demonstrates grouping objects by a property.
 * Here, we group Employees by their Department.
 */
public class EmployeeGrouping {

    static class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        System.out.println("Employees: " + employees.toString()); // Basic print just to show input

        Map<String, List<Employee>> byDept = groupByDepartment(employees);

        System.out.println("Grouped by Department: " + byDept);
    }

    /**
     * Groups employees by department.
     * 
     * @param employees List of employees
     * @return Map of Department -> List of Employees
     */
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            map.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        return map;
    }
}
