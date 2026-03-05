package json;

import org.json.JSONObject;

/**
 * Merges two JSON objects into a single JSON object.
 */
public class MergeJsonObjects {
    public static void main(String[] args) {
        // Create first JSON Object
        JSONObject json1 = new JSONObject();
        json1.put("id", 101);
        json1.put("name", "Bob");
        
        // Create second JSON Object
        JSONObject json2 = new JSONObject();
        json2.put("department", "IT");
        json2.put("salary", 75000);
        
        // Merge json2 into json1
        for (String key : json2.keySet()) {
            // Put each key-value pair from json2 into json1
            json1.put(key, json2.get(key));
        }
        
        // Print the merged object
        System.out.println("Merged JSON:");
        System.out.println(json1.toString(4));
    }
}
