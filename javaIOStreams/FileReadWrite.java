package javaIOStreams;

/*
 * Program 1: File Handling - Read and Write a Text File
 * Maximum 3 lines of description.
 * Reads content from 'source.txt' and writes it to 'destination.txt'.
 * Handles cases where source file does not exist.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileReadWrite {

    public static void main(String[] args) {
        // Source and destination file paths
        String sourcePath = "source.txt";
        String destPath = "destination.txt";

        // Creating a dummy source file for testing if it doesn't exist
        createDummySourceFile(sourcePath);

        // Using try-with-resources to ensure streams are closed automatically
        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath)) {

            int byteContent;
            // Read byte by byte from source and write to destination
            while ((byteContent = fis.read()) != -1) {
                fos.write(byteContent);
            }

            System.out.println("File content copied successfully from " + sourcePath + " to " + destPath);

        } catch (IOException e) {
            // Handle IO exceptions
            System.out.println("An error occurred during file operations: " + e.getMessage());
        }
    }

    // Helper method to create a source file if it doesn't exist
    private static void createDummySourceFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                String content = "Hello, this is a test content for FileReadWrite program.";
                fos.write(content.getBytes());
                System.out.println("Created dummy source file: " + path);
            } catch (IOException e) {
                System.out.println("Failed to create dummy source file: " + e.getMessage());
            }
        }
    }
}
