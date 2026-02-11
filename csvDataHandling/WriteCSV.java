package csvDataHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 2. Write Data to a CSV File
 * Creates a CSV file with employee details (ID, Name, Department, Salary).
 * Writes at least 5 records to the file.
 */
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Output file path

        // Try-with-resources to ensure the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header row
            writer.write("ID,Name,Department,Salary");
            writer.newLine(); // Move to next line

            // Write 5 records
            writer.write("101,Amit Sharma,Engineering,60000");
            writer.newLine();
            writer.write("102,Priya Singh,HR,50000");
            writer.newLine();
            writer.write("103,Rohan Verma,Marketing,55000");
            writer.newLine();
            writer.write("104,Sneha Gupta,Finance,62000");
            writer.newLine();
            writer.write("105,Vikram Patel,Sales,58000");
            writer.newLine();

            System.out.println("Data successfully written to " + filePath);
        } catch (IOException e) {
            // Handle IO exceptions
            e.printStackTrace();
        }
    }
}
