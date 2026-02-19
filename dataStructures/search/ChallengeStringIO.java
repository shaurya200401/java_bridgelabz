package dataStructures.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and
 * InputStreamReader.
 */
public class ChallengeStringIO {

    public static void main(String[] args) {
        // Part 1: Compare StringBuilder and StringBuffer
        int iterations = 1000000;
        String text = "test";

        System.out.println("--- String Concatenation Performance ---");

        // StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1000000 + " ms");

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1000000 + " ms");

        // Part 2: File reading
        System.out.println("\n--- File Reading Performance ---");
        String filePath = "large_sample.txt";
        createLargeDummyFile(filePath); // Create a somewhat large file

        // FileReader
        startTime = System.nanoTime();
        int wordCountFileReader = countWordsFileReader(filePath);
        endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCountFileReader);
        System.out.println("FileReader time: " + (endTime - startTime) / 1000000 + " ms");

        // InputStreamReader (Conceptually similar for local files, usually used for
        // streams)
        // Here we simulate checking if there's any difference overhead or usage
        // Note: FileReader extends InputStreamReader, so difference might be negligible
        // unless charset handling differs
        startTime = System.nanoTime();
        int wordCountISR = countWordsInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCountISR);
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1000000 + " ms");
    }

    // Method using FileReader
    private static int countWordsFileReader(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count += line.split("\\s+").length;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    // Method using InputStreamReader with FileInputStream
    private static int countWordsInputStreamReader(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(
                new java.io.InputStreamReader(new java.io.FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count += line.split("\\s+").length;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static void createLargeDummyFile(String filePath) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            // Write 10000 lines
            for (int i = 0; i < 10000; i++) {
                fw.write("This is a sample line of text to simulate a large file for performance testing. ");
                fw.write("Repeating words to increase file size. Java I/O performance check.\n");
            }
        } catch (IOException e) {
            System.err.println("Could not create dummy file: " + e.getMessage());
        }
    }
}
