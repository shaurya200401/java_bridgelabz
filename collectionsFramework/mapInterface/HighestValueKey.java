package collectionsFramework.mapInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates how to find the key associated with the highest value
 * in a Map.
 */
public class HighestValueKey {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println("Map: " + map);

        String maxKey = getKeyWithHighestValue(map);
        System.out.println("Key with highest value: " + maxKey);
    }

    /**
     * Finds the key with the maximum value.
     * 
     * @param map Input map
     * @return Key with max value, or null if empty
     */
    public static String getKeyWithHighestValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        // Use Collections.max to find entry with max value
        Map.Entry<String, Integer> maxEntry = Collections.max(
                map.entrySet(),
                Map.Entry.comparingByValue());

        return maxEntry.getKey();
    }
}
