package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 4. Filter Records from CSV
 * Reads a CSV file and filters students who have scored more than 80 marks.
 * Prints only the qualifying records.
 */
public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read header
            String header = br.readLine();
            System.out.println("Students with marks > 80:");
            System.out.println(header); // Optional: print header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    try {
                        int marks = Integer.parseInt(columns[3].trim());
                        if (marks > 80) {
                            System.out.println(line);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid marks format for line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
