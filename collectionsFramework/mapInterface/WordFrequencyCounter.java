package collectionsFramework.mapInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates reading a file and counting word frequencies using a
 * HashMap.
 * It ignores case and punctuation.
 */
public class WordFrequencyCounter {

    public static void main(String[] args) {
        String filePath = "collectionsFramework/mapInterface/sample.txt";
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words using regex (non-word characters as delimiters)
                String[] words = line.split("[^a-zA-Z0-9]+");

                for (String word : words) {
                    if (word.isEmpty())
                        continue;

                    // Convert to lower case for consistency
                    String key = word.toLowerCase();

                    // Update count in map using getOrDefault
                    wordCounts.put(key, wordCounts.getOrDefault(key, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the result
        System.out.println("Word Frequencies: " + wordCounts);
    }
}
