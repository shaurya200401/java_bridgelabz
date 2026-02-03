package exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Program 14: Try-With-Resources with Multiple Resources
 * 
 * Problem Statement:
 * Read data from two different files and write the combined result to a third
 * file.
 * Ensure that all resources are properly closed, even if an exception occurs.
 */
public class FileMerge {
    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String outputFile = "merged_output.txt";

        // Create dummy files for demonstration
        createDummyFiles(file1, "Content from File 1\n");
        createDummyFiles(file2, "Content from File 2\n");

        System.out.println("Attempting to merge " + file1 + " and " + file2 + " into " + outputFile);

        // Multiple resources in try-with-resources
        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;

            // Read and write from first file
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Read and write from second file
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Merge completed successfully.");

        } catch (IOException e) {
            System.out.println("Error during file merge operation: " + e.getMessage());
        }
    }

    // Helper to create dummy files so the program actually runs
    private static void createDummyFiles(String name, String content) {
        try (FileWriter fw = new FileWriter(name)) {
            fw.write(content);
        } catch (IOException e) {
            System.out.println("Setup failed: " + e.getMessage());
        }
    }
}
