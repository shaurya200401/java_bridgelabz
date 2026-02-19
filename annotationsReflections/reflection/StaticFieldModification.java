package annotationsReflections.reflection;

import java.lang.reflect.Field;

/*
 * PROBLEM: Access and Modify Static Fields
 * Problem Statement:
 * Create a Configuration class with a private static field API_KEY. 
 * Use Reflection to modify its value and print it.
 * Concepts Tested:
 *  Field.get(null) - static modification
 *  Field.set(null)
 */
class Configuration {
    private static String API_KEY = "12345-ABCDE";

    public static void displayConfig() {
        System.out.println("Current API_KEY: " + API_KEY);
    }
}

public class StaticFieldModification {
    public static void main(String[] args) {
        try {
            System.out.println("Before Modification:");
            Configuration.displayConfig();

            Class<?> clazz = Configuration.class;
            Field field = clazz.getDeclaredField("API_KEY");

            // Make private static field accessible
            field.setAccessible(true);

            // Modify static field (pass null as object instance)
            System.out.println("\nModifying API_KEY...");
            field.set(null, "98765-ZYXWV");

            System.out.println("After Modification:");
            Configuration.displayConfig();

            // Verify via reflection get
            String newValue = (String) field.get(null);
            System.out.println("Retrieved via Reflection: " + newValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
