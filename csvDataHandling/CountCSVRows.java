package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 3. Read and Count Rows in a CSV File
 * Reads a CSV file and counts the number of records (excluding the header row).
 */
public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Using the file created in problem 2
        int count = 0;

        // Try-with-resources for automatic resource management
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header
            if (br.readLine() != null) {
                // Header read, now counting data rows
                while ((line = br.readLine()) != null) {
                    // Start counting only if the line is not empty
                    if (!line.trim().isEmpty()) {
                        count++;
                    }
                }
            }

            System.out.println("Total number of records in " + filePath + ": " + count);
        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
