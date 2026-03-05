package json;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Filters JSON data to print only users older than 25 years.
 * Hands-on Practice Session.
 */
public class FilterUsersByAge {
    public static void main(String[] args) {
        // Seed JSON string representing an array of users
        String jsonInput = "[{\"user\":\"Dave\",\"age\":24}, {\"user\":\"Eve\",\"age\":31}, {\"user\":\"Frank\",\"age\":29}]";

        // Parse into JSON array
        JSONArray array = new JSONArray(jsonInput);

        System.out.println("Users older than 25:");

        // Iterate and filter
        for (int i = 0; i < array.length(); i++) {
            JSONObject userObj = array.getJSONObject(i);

            // Check condition for filtering
            if (userObj.getInt("age") > 25) {
                // Print matched user
                System.out.println(userObj.toString(2));
            }
        }
    }
}
