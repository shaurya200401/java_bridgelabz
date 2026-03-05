package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.Map;

/**
 * Reads a JSON payload and prints all keys and their corresponding values.
 */
public class PrintAllKeysAndValues {
    public static void main(String[] args) {
        // Sample JSON string to parse
        String jsonInput = "{\"id\": 1, \"title\": \"Engineer\", \"company\": \"Tech Corp\"}";

        // Initialize mapper
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Parse JSON input
            JsonNode rootNode = mapper.readTree(jsonInput);

            // Iterate through the fields
            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            System.out.println("Printing Keys and Values:");

            // Loop while fields exist
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String key = field.getKey();
                JsonNode value = field.getValue();

                // Print key value pair
                System.out.println("Key: " + key + ", Value: " + value.asText());
            }
        } catch (Exception e) {
            // Handle potential errors
            e.printStackTrace();
        }
    }
}
