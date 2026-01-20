package dataStructures.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to count the occurrence of a word in a file using FileReader.
 */
public class CountWordOccurrence {

    // Method to count occurrences
    public static int countWord(String filePath, String targetWord) {
        int count = 0;

        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words
                String[] words = line.split("\\W+"); // Split by non-word characters

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";
        String targetWord = "Java";

        // Ensure dummy file exists (relying on previous run or creating again)
        createDummyFile(filePath);

        int occurrences = countWord(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in " + filePath);
    }

    private static void createDummyFile(String filePath) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            fw.write("Java is a programming language.\n");
            fw.write("Java is versatile.\n");
            fw.write("I love Java.\n");
        } catch (IOException e) {
            System.err.println("Could not create dummy file: " + e.getMessage());
        }
    }
}
