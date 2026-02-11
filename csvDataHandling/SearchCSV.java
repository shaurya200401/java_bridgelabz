package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * 5. Search for a Record in CSV
 * Reads an employees.csv file and searches for an employee by name.
 * Prints their department and salary.
 */
public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String searchName = "Priya Singh"; // Hardcoded for this example as per practice style, or could use Scanner

        System.out.println("Searching for employee: " + searchName);

        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header check

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    // Assuming Name is at index 1
                    String name = columns[1].trim();
                    if (name.equalsIgnoreCase(searchName)) {
                        System.out.println("Employee Found: " + name);
                        System.out.println("Department: " + columns[2]);
                        System.out.println("Salary: " + columns[3]);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
