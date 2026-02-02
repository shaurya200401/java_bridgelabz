package javaIOStreams;

/*
 * Program 10: Count Words in a File
 * Counts the number of words in a given text file.
 * Displays the top 5 most frequently occurring words.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) {
        String filePath = "text_analysis.txt";

        // Create dummy file
        createDummyTextFile(filePath);

        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Fixed: readLine() returns null at EOF
            while ((line = reader.readLine()) != null) {
                // Split line into words using regex (non-word characters as delimiters)
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Total unique words: " + wordCounts.size());

        System.out.println("Top 5 most frequent words:");
        wordCounts.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort by count descending
                .limit(5) // Top 5
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void createDummyTextFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                String content = "Java is a programming language. Java is widely used. " +
                        "Programming in Java is fun. Java streams are powerful. " +
                        "File handling in Java is easy efficiently. BufferedReader is efficient. " +
                        "Java Java Java Code Code Code";
                writer.write(content);
                System.out.println("Created dummy text file: " + path);
            } catch (IOException e) {
                System.out.println("Failed to create text file: " + e.getMessage());
            }
        }
    }
}
