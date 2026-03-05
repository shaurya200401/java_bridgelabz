package json;

import org.json.JSONObject;
import org.json.XML;

/**
 * Converts a given JSON structure to XML format using org.json XML
 * capabilities.
 */
public class ConvertJsonToXml {
    public static void main(String[] args) {
        // Pre-defined JSON text
        String jsonText = "{\"person\": {\"name\": \"Tom\", \"age\": 40}}";

        try {
            // Construct JSON object from string
            JSONObject jsonObject = new JSONObject(jsonText);

            // Leverage org.json.XML utility for conversion
            String xmlText = XML.toString(jsonObject);

            // Output the translated XML text
            System.out.println("Parsed XML Result:");
            System.out.println("<root>" + xmlText + "</root>");
        } catch (Exception e) {
            // Handle JSON/XML mapping failures
            e.printStackTrace();
        }
    }
}
