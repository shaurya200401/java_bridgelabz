package csvDataHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 6. Modify a CSV File (Update a Value)
 * Reads a CSV file and increases the salary of employees from the "IT" department by 10%.
 * Saves the updated records back to a new CSV file.
 */
public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";
        List<String> validLines = new ArrayList<>();

        // Read and process data
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            // Handle header
            String header = br.readLine();
            if (header != null)
                validLines.add(header);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    String department = columns[2].trim();
                    if ("IT".equalsIgnoreCase(department)) {
                        try {
                            double salary = Double.parseDouble(columns[3].trim());
                            double newSalary = salary * 1.10; // 10% increase
                            columns[3] = String.valueOf((int) newSalary); // Update salary (casting to int for
                                                                          // simplicity)
                            line = String.join(",", columns); // Reconstruct line
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid salary format: " + columns[3]);
                        }
                    }
                }
                validLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : validLines) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Updated records saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
