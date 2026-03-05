package json;

import org.json.JSONObject;

/**
 * Validates an email field within a JSON object using regex as a simple schema
 * proxy.
 */
public class ValidateEmailJsonSchema {
    public static void main(String[] args) {
        // Construct JSON object with an email
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "testUser");
        jsonObject.put("email", "john.doe@example.com");

        // Basic pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Check if email field exists
        if (jsonObject.has("email")) {
            String email = jsonObject.getString("email");

            // Apply regex to simulate schema validation
            if (email.matches(emailRegex)) {
                System.out.println("Email field is valid formatted: " + email);
            } else {
                System.out.println("Email field validation failed.");
            }
        } else {
            // Missing email handling
            System.out.println("JSON does not contain an email field.");
        }
    }
}
