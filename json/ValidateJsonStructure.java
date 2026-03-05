package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Validates a JSON structure using Jackson library.
 */
public class ValidateJsonStructure {
    public static void main(String[] args) {
        // JSON string to validate
        String jsonInput = "{\"username\": \"john_doe\", \"age\": 25, \"active\": true}";

        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Parse string into tree model
            JsonNode rootNode = mapper.readTree(jsonInput);

            // Check for required fields and their types
            boolean hasUsername = rootNode.has("username") && rootNode.get("username").isTextual();
            boolean hasAge = rootNode.has("age") && rootNode.get("age").isInt();
            boolean hasActive = rootNode.has("active") && rootNode.get("active").isBoolean();

            if (hasUsername && hasAge && hasActive) {
                // All validation passes
                System.out.println("JSON structure is perfectly valid.");
            } else {
                // Some fields are missing or wrongly typed
                System.out.println("JSON structure validation failed.");
            }
        } catch (Exception e) {
            // Invalid JSON format
            System.out.println("Invalid JSON format: " + e.getMessage());
        }
    }
}
