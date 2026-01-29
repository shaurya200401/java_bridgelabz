package collectionsFramework.listInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class demonstrates how to count the frequency of each element in a List
 * and return the result as a Map.
 */
public class ElementFrequency {

    public static void main(String[] args) {
        // Create a list of strings with some duplicates
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");

        System.out.println("Input List: " + fruits);

        // Get the frequency map
        Map<String, Integer> frequencyMap = findFrequency(fruits);

        // Display the result
        System.out.println("Frequency Map: " + frequencyMap);
    }

    /**
     * Counts the frequency of each string in the provided list.
     * 
     * @param list Valid list of strings
     * @return A Map containing the string as key and its count as value
     */
    public static Map<String, Integer> findFrequency(List<String> list) {
        // Create a HashMap to store frequencies
        Map<String, Integer> map = new HashMap<>();

        // Iterate over each element in the list
        for (String item : list) {
            // If key exists, increment count; otherwise put 1
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        return map;
    }
}
