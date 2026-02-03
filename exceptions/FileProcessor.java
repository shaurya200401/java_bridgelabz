package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Program 11: Try-With-Resources
 * 
 * Problem Statement:
 * Create a class FileProcessor with a method processFiles(List<String>
 * filePaths)
 * that reads the contents of each file.
 * Handle IOException and ensure resources are closed using try-with-resources.
 */
public class FileProcessor {

    public void processFiles(List<String> filePaths) {
        for (String splitPath : filePaths) {
            System.out.println("Processing file: " + splitPath);
            // Try-with-resources automatically closes the BufferedReader
            try (BufferedReader reader = new BufferedReader(new FileReader(splitPath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file " + splitPath + ": " + e.getMessage());
            }
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();

        // Example file paths (assuming these files may or may not exist)
        List<String> files = Arrays.asList("data.txt", "info.txt", "missing.txt");

        processor.processFiles(files);
    }
}
