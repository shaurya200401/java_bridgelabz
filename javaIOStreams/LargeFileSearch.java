package javaIOStreams;

/*
 * Program 9: Read a Large File Line by Line
 * efficiently reads a large text file line by line using BufferedReader.
 * Prints only lines containing the word "error" (case insensitive).
 */

import java.io.*;

public class LargeFileSearch {

    public static void main(String[] args) {
        String filePath = "large_log_file.txt";
        String searchWord = "error";

        // Create dummy large file with some error lines
        createDummyLogFile(filePath);

        System.out.println("Scanning file for '" + searchWord + "'...");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            // Fixed: readLine() returns null at EOF
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("Line " + lineNumber + ": " + line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void createDummyLogFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 1; i <= 1000; i++) {
                    if (i % 50 == 0) {
                        writer.write("Trace: Something went wrong here. Error: Connection failed.\n");
                    } else if (i % 120 == 0) {
                        writer.write("Critical ERROR: System crash imminent!\n");
                    } else {
                        writer.write("Info: Operation " + i + " completed successfully.\n");
                    }
                }
                System.out.println("Created dummy log file: " + path);
            } catch (IOException e) {
                System.out.println("Failed to create log file: " + e.getMessage());
            }
        }
    }
}
