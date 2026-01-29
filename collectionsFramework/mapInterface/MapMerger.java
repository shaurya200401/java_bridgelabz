package collectionsFramework.mapInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates merging two maps.
 * If a key exists in both, their values are summed.
 */
public class MapMerger {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);

        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        System.out.println("Merged Map: " + mergedMap);
    }

    /**
     * Merges two maps, summing values for common keys.
     * 
     * @param m1 First map
     * @param m2 Second map
     * @return A new map with merged data
     */
    public static Map<String, Integer> mergeMaps(Map<String, Integer> m1, Map<String, Integer> m2) {
        // Create a copy of m1
        Map<String, Integer> result = new HashMap<>(m1);

        // Merge m2 into result
        // forEach is convenient here
        m2.forEach((key, value) -> result.merge(key, value, Integer::sum));

        return result;
    }
}
