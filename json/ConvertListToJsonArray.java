package json;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts a list of Java objects into a JSON array using org.json.
 * Hand-on Practice Session.
 */
public class ConvertListToJsonArray {

    // Sample domain class
    static class Product {
        public int id;
        public String name;

        // Overloaded constructor
        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // Prepare list
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop"));
        products.add(new Product(2, "Phone"));

        // Create root array
        JSONArray jsonArray = new JSONArray();

        // Loop and build JSON objects
        for (Product p : products) {
            JSONObject obj = new JSONObject();
            obj.put("id", p.id);
            obj.put("name", p.name);
            jsonArray.put(obj);
        }

        // Output array structure
        System.out.println("JSON Array from List:");
        System.out.println(jsonArray.toString(2));
    }
}
