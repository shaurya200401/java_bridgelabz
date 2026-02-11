package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 1. Read a CSV File and Print Data
 * Reads a CSV file containing student details (ID, Name, Age, Marks).
 * Prints each record in a structured format.
 */
public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to the CSV file

        // Try-with-resources to ensure the reader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading data from " + filePath + ":");
            
            // Read the header line
            if ((line = br.readLine()) != null) {
                System.out.println("Header: " + line);
            }

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] columns = line.split(",");
                
                // Print the data in a structured format
                if (columns.length >= 4) {
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Age: " + columns[2] + ", Marks: " + columns[3]);
                }
            }
        } catch (IOException e) {
            // Handle IO exceptions
            e.printStackTrace();
        }
    }
}
