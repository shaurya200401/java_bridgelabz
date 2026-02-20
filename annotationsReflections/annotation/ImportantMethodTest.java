package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * Problem 1: Create an Annotation to Mark Important Methods
 * Problem Statement:
 * Define a custom annotation @ImportantMethod that can be applied to methods to indicate their importance.
 * Requirements:
 * 1. Define @ImportantMethod with an optional level parameter (default: "HIGH").
 * 2. Apply it to at least two methods.
 * 3. Retrieve and print annotated methods using Reflection API.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH"; // Default importance level
}

/*
 * Class with important methods
 */
class Service {
    @ImportantMethod
    public void initialize() {
        System.out.println("Initialization...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void processData() {
        System.out.println("Processing data...");
    }

    public void cleanup() {
        System.out.println("Cleanup...");
    }
}

/*
 * Main class to inspect annotated methods
 */
public class ImportantMethodTest {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();

        System.out.println("Scanning methods for @ImportantMethod...");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Importance: " + annotation.level());
            }
        }
    }
}
