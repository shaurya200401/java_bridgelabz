package javaIOStreams;

/*
 * Program 6: Filter Streams - Convert Uppercase to Lowercase
 * Reads a text file and writes its content to another file,
 * converting all uppercase letters to lowercase.
 */

import java.io.*;

public class CaseConverter {

    public static void main(String[] args) {
        String sourceFile = "mixed_case_source.txt";
        String destFile = "lowercase_dest.txt";

        // Create dummy file
        createDummyFile(sourceFile);

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            // Fixed: readLine() returns null at EOF, not -1
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase and write
                writer.write(line.toLowerCase());
                writer.newLine(); // Add new line since readLine strips it
            }

            System.out.println("Conversion completed. Check " + destFile);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    private static void createDummyFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("HELLO World! This Is A MixEd CaSe FiLe.\n");
                fw.write("JAVA IO STREAMS are POWERFUL.\n");
                System.out.println("Created dummy file: " + path);
            } catch (IOException e) {
                System.out.println("Failed to create dummy file: " + e.getMessage());
            }
        }
    }
}
