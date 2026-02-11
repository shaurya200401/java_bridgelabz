package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * 12. Detect Duplicates in a CSV File
 * Reads a CSV file and detects duplicate entries based on the ID column.
 * Prints all duplicate records.
 */
public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "duplicates.csv";
        Set<String> existingIDs = new HashSet<>();

        System.out.println("Checking for duplicates in " + filePath + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > 0) {
                    String id = columns[0].trim();

                    if (existingIDs.contains(id)) {
                        System.out.println("Duplicate found: " + line);
                    } else {
                        existingIDs.add(id);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
