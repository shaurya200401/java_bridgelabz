package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Merges the contents of two separate JSON files into a single object and saves
 * it.
 */
public class MergeJsonFiles {
    public static void main(String[] args) {
        // Setup initial filenames
        String file1 = "data1.json";
        String file2 = "data2.json";
        String out = "merged.json";

        // Dump dummy content for merging
        writeToFile(file1, "{\"keyA\": \"valueA\"}");
        writeToFile(file2, "{\"keyB\": \"valueB\"}");

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read both files
            JsonNode node1 = mapper.readTree(new File(file1));
            JsonNode node2 = mapper.readTree(new File(file2));

            // Expect them to be objects
            if (node1.isObject() && node2.isObject()) {
                ObjectNode mergedNode = ((ObjectNode) node1).deepCopy();
                mergedNode.setAll((ObjectNode) node2);

                // Write output to third file
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(out), mergedNode);
                System.out.println("Successfully merged into file: " + out);
            }
        } catch (Exception e) {
            // Handle merging errors
            e.printStackTrace();
        }
    }

    // Helper functionality
    private static void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
