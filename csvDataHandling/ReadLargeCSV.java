package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 11. Read Large CSV File Efficiently
 * Given a large CSV file, implements a memory-efficient way to read it in chunks.
 * Processes only 100 lines at a time and displays the count of records processed.
 */
public class ReadLargeCSV {
    public static void main(String[] args) {
        // Using a regular file for demonstration, logic applies to large files
        String filePath = "csvDataHandling/csv/students.csv";
        int batchSize = 2; // Using smaller batch size for demonstration with small file. Change to 100 for
                           // actual large file.

        System.out.println("Reading file in chunks of " + batchSize + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            int totalProcessed = 0;

            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                // Process line (e.g., parse or validate)
                // System.out.println(line); // Commented out to simulate just processing

                count++;

                if (count == batchSize) {
                    totalProcessed += count;
                    System.out.println("Processed " + totalProcessed + " records so far...");
                    count = 0; // Reset batch count

                    // Simulate processing delay or memory clear if needed
                }
            }

            if (count > 0) {
                totalProcessed += count;
                System.out.println("Processed remaining " + count + " records.");
            }

            System.out.println("Total records processed: " + totalProcessed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
