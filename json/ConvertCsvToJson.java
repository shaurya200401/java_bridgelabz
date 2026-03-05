package json;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Converts manually parsed CSV data into a JSON array structure.
 */
public class ConvertCsvToJson {
    public static void main(String[] args) {
        // Sample CSV string data
        String csvData = "id,name,role\n1,Alpha,Admin\n2,Beta,User";

        // Split by newlines
        String[] lines = csvData.split("\n");
        JSONArray jsonArray = new JSONArray();

        // Parse CSV if not empty
        if (lines.length > 1) {
            // Save headings
            String[] headers = lines[0].split(",");

            // Traverse rows
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");
                JSONObject obj = new JSONObject();

                // Map heading to corresponding value
                for (int j = 0; j < headers.length; j++) {
                    obj.put(headers[j].trim(), values[j].trim());
                }

                // Bundle object to array
                jsonArray.put(obj);
            }
        }

        // Present the outcome
        System.out.println("Converted JSON Array:");
        System.out.println(jsonArray.toString(2));
    }
}
