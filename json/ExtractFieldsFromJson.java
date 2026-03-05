package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Reads a JSON file and extracts specific fields (e.g., name, email).
 */
public class ExtractFieldsFromJson {
    public static void main(String[] args) {
        // Sample JSON string to write to dummy file
        String jsonString = "{\"user\": {\"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 30}}";
        File file = new File("sample_extract.json");
        
        try (FileWriter writer = new FileWriter(file)) {
            // Write sample JSON
            writer.write(jsonString);
        } catch (IOException e) {
            System.out.println("Error writing sample file");
        }

        // Initialize ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Read file into JsonNode
            JsonNode rootNode = mapper.readTree(file);
            JsonNode userNode = rootNode.get("user");
            
            if (userNode != null) {
                // Extract specific fields
                String name = userNode.has("name") ? userNode.get("name").asText() : "N/A";
                String email = userNode.has("email") ? userNode.get("email").asText() : "N/A";
                
                // Print extracted fields
                System.out.println("Extracted Name: " + name);
                System.out.println("Extracted Email: " + email);
            }
        } catch (Exception e) {
            // Handle evaluation exception
            e.printStackTrace();
        }
    }
}
