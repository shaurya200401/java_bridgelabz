package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Parses a JSON array and filters out records where age is greater than 25.
 */
public class FilterJsonByAge {
    public static void main(String[] args) {
        // Sample JSON payload containing list of persons
        String jsonInput = "[{\"name\":\"Ali\",\"age\":20}, {\"name\":\"Ben\",\"age\":30}, {\"name\":\"Cat\",\"age\":28}]";

        // Init ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read root array node
            JsonNode rootNode = mapper.readTree(jsonInput);

            // Prepare a filtered array
            ArrayNode filteredArray = mapper.createArrayNode();

            if (rootNode.isArray()) {
                // Iterate over all elements
                for (JsonNode node : rootNode) {
                    // Check age condition
                    if (node.has("age") && node.get("age").asInt() > 25) {
                        filteredArray.add(node);
                    }
                }
            }

            // Print the filtered results
            System.out.println("Filtered JSON (Age > 25):");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray));

        } catch (Exception e) {
            // Handle parsing faults
            e.printStackTrace();
        }
    }
}
