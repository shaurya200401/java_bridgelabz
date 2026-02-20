package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/*
 * Problem 4: Create a @MaxLength Annotation for Field Validation
 * Problem Statement:
 * Define a field-level annotation @MaxLength(int value) that restricts the maximum length of a String field.
 * Requirements:
 * 1. Apply it to a User class field (username).
 * 2. Validate length in the constructor.
 * 3. Throw IllegalArgumentException if the limit is exceeded.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

/*
 * User class with validation
 */
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateFields();
    }

    private void validateFields() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();

                try {
                    // Make private checking accessible if needed, though we are in the class
                    field.setAccessible(true);
                    String value = (String) field.get(this);

                    if (value.length() > maxLength) {
                        throw new IllegalArgumentException(
                                "Field '" + field.getName() + "' exceeds max length of " + maxLength);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

/*
 * Main class to test validation
 */
public class FieldValidationTest {
    public static void main(String[] args) {
        try {
            System.out.println("Creating valid user...");
            User validUser = new User("JohnDoe");
            System.out.println("User created: " + validUser.getUsername());

            System.out.println("\nCreating invalid user...");
            User invalidUser = new User("ThisUsernameIsTooLong");

        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
