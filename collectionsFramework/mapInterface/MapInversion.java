package collectionsFramework.mapInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class demonstrates how to invert a Map (swap keys and values).
 * Since multiple keys might map to the same value in the original map,
 * the inverted map maps a value to a List of keys.
 */
public class MapInversion {

    public static void main(String[] args) {
        // Create original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        System.out.println("Original Map: " + originalMap);

        // Invert map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        System.out.println("Inverted Map: " + invertedMap);
    }

    /**
     * Inverts a map.
     * 
     * @param map The original map (Key -> Value)
     * @return The inverted map (Value -> List<Key>)
     */
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Computes if absent: creates a new list if the key (value) doesn't exist
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return inverted;
    }
}
