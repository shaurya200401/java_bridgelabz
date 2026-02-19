package annotationsReflections.reflection;

import java.lang.reflect.Field;

/*
 * PROBLEM: Generate a JSON Representation
 * Problem Statement:
 * Write a program that converts an object to a JSON-like string using Reflection 
 * by inspecting its fields and values.
 * Concepts Tested:
 *  Field iteration
 *  Building strings dynamically
 */

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class JsonGenerator {
    public static String toJson(Object obj) {
        if (obj == null)
            return "null";

        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder();
        json.append("{\n");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                json.append("  \"").append(field.getName()).append("\": ");
                Object value = field.get(obj);

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(",");
                }
                json.append("\n");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Product product = new Product(101, "Laptop", 999.99);
        System.out.println("Generating JSON for Product object...");
        String jsonOutput = toJson(product);
        System.out.println(jsonOutput);
    }
}
