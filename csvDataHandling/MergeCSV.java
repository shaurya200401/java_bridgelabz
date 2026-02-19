package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/*
 * 10. Merge Two CSV Files
 * Merges students1.csv (ID, Name, Age) and students2.csv (ID, Marks, Grade) based on ID.
 * Creates a new file containing all details.
 */
public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "csvDataHandling/csv/students1.csv";
        String file2 = "csvDataHandling/csv/students2.csv";
        String outputFile = "csvDataHandling/csv/merged_students.csv";

        // Map to store data: ID -> Content from File 1
        Map<String, String> studentData = new HashMap<>();

        // Read File 1
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 1) {
                    studentData.put(columns[0].trim(), line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read File 2 and Write Merge Result
        try (BufferedReader br = new BufferedReader(new FileReader(file2));
                PrintWriter pw = new PrintWriter(outputFile)) {

            pw.println("ID,Name,Age,Marks,Grade"); // Write new header

            String line;
            br.readLine(); // Skip header of file 2
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 3) {
                    String id = columns[0].trim();
                    if (studentData.containsKey(id)) {
                        String part1 = studentData.get(id);
                        // Append Marks and Grade from File 2 (columns 1 and 2)
                        String mergedLine = part1 + "," + columns[1].trim() + "," + columns[2].trim();
                        pw.println(mergedLine);
                    }
                }
            }
            System.out.println("Merged file created: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
