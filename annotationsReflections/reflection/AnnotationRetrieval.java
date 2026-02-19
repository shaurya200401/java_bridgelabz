package annotationsReflections.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

/*
 * PROBLEM: Retrieve Annotations at Runtime
 * Problem Statement:
 * Create a custom annotation @Author(name="Author Name"). 
 * Apply it to a class and use Reflection to retrieve and display the annotation value at runtime.
 * Concepts Tested:
 *  Custom Annotation definition
 *  isAnnotationPresent()
 *  getAnnotation()
 */

// Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply annotation to class
@Author(name = "John Doe")
class Book {
    public void read() {
        System.out.println("Reading book...");
    }
}

public class AnnotationRetrieval {
    public static void main(String[] args) {
        Class<?> clazz = Book.class;

        // Check if annotation is present
        if (clazz.isAnnotationPresent(Author.class)) {
            // Retrieve annotation
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Class " + clazz.getSimpleName() + " is written by: " + author.name());
        } else {
            System.out.println("No Author annotation found.");
        }
    }
}
