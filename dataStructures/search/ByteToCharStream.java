package dataStructures.search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Class to convert Byte Stream to Character Stream using InputStreamReader.
 */
public class ByteToCharStream {

    public static void readStream(String filePath) {
        // Create FileInputStream to read binary data
        try (FileInputStream fis = new FileInputStream(filePath);
                // Wrap in InputStreamReader to convert bytes to chars
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                // Wrap in BufferedReader for efficiency
                BufferedReader br = new BufferedReader(isr)) {

            String line;
            System.out.println("Reading content from " + filePath + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading stream: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample_utf8.txt";

        createDummyFile(filePath);
        readStream(filePath);
    }

    private static void createDummyFile(String filePath) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            fw.write("This is a file with UTF-8 content.\n");
            fw.write("Testing byte to char conversion.\n");
        } catch (IOException e) {
            System.err.println("Could not create dummy file: " + e.getMessage());
        }
    }
}
