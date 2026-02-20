package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Problem 6: Implement a Custom Serialization Annotation @JsonField
 * Problem Statement:
 * Define an annotation @JsonField to mark fields for JSON serialization.
 * Requirements:
 * 1. @JsonField(name = "user_name") should map field names to custom JSON keys.
 * 2. Apply it on a User class.
 * 3. Write a method to convert object to JSON string by reading the annotations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name() default "";
}

/*
 * User class for serialization
 */
class JsonUser {
    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    private String password; // Should be ignored (no annotation)

    public JsonUser(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}

/*
 * Main class for JSON serialization
 */
public class JsonSerializationTest {

    public static String convertToJson(Object object) {
        try {
            Class<?> clazz = object.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields
                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField jsonField = field.getAnnotation(JsonField.class);
                    String key = jsonField.name().isEmpty() ? field.getName() : jsonField.name();
                    Object value = field.get(object);

                    // Simple string serialization
                    String jsonValue;
                    if (value instanceof String) {
                        jsonValue = "\"" + value.toString() + "\"";
                    } else {
                        jsonValue = String.valueOf(value);
                    }

                    jsonMap.put("\"" + key + "\"", jsonValue);
                }
            }

            String jsonString = jsonMap.entrySet().stream()
                    .map(entry -> entry.getKey() + ":" + entry.getValue())
                    .collect(Collectors.joining(","));

            return "{" + jsonString + "}";

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static void main(String[] args) {
        JsonUser user = new JsonUser("Alice", 30, "secret123");
        System.out.println("Serializing user object...");
        String json = convertToJson(user);
        System.out.println("JSON Output: " + json);
    }
}
