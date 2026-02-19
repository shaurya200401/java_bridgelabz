package annotationsReflections.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*
 * PROBLEM: Create a Custom Object Mapper
 * Problem Statement:
 * Implement a method toObject(Class<T> clazz, Map<String, Object> properties) that 
 * uses Reflection to set field values from a given Map.
 * Concepts Tested:
 *  Instantiation
 *  Field access and setting values dynamically
 */

class User {
    private String name;
    private int age;
    private String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create instance
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Field not found: " + fieldName);
                }
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> userProperties = new HashMap<>();
        userProperties.put("name", "Alice");
        userProperties.put("age", 28);
        userProperties.put("email", "alice@example.com");
        userProperties.put("unknownField", "ignoreMe");

        System.out.println("Mapping map to User object...");
        User user = toObject(User.class, userProperties);
        System.out.println("Mapped Object: " + user);
    }
}
