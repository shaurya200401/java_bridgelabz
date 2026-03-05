package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts a list of Java objects into a JSON array format.
 */
public class ListToJsonArray {

    // Simple Employee class
    static class Employee {
        public String name;
        public String role;

        // Constructor
        public Employee(String name, String role) {
            this.name = name;
            this.role = role;
        }
    }

    public static void main(String[] args) {
        // Create a list to hold employees
        List<Employee> employeeList = new ArrayList<>();

        // Add sample objects
        employeeList.add(new Employee("Alice", "Developer"));
        employeeList.add(new Employee("Bob", "Manager"));

        // Use ObjectMapper for conversion
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Write list as JSON array string
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);

            // Output resulting array
            System.out.println("JSON Array Output:");
            System.out.println(jsonArray);
        } catch (Exception e) {
            // Handle conversion error
            e.printStackTrace();
        }
    }
}
