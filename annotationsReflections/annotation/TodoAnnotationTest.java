package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * Problem 2: Create a @Todo Annotation for Pending Tasks
 * Problem Statement:
 * Define an annotation @Todo to mark pending features in a project.
 * Requirements:
 * 1. The annotation should have fields:
 *    - task() (String) -> Description of the task
 *    - assignedTo() (String) -> Developer responsible
 *    - priority() (default: "MEDIUM")
 * 2. Apply it to multiple methods.
 * 3. Retrieve and print all pending tasks using Reflection.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();

    String assignedTo();

    String priority() default "MEDIUM";
}

/*
 * Class with pending tasks
 */
class ProjectFeatures {

    @Todo(task = "Implement login", assignedTo = "John", priority = "HIGH")
    public void login() {
        // Not implemented yet
    }

    @Todo(task = "Add logout", assignedTo = "Jane")
    public void logout() {
        // Not implemented yet
    }

    public void dashboard() {
        // Implemented
    }
}

/*
 * Main class to list todos
 */
public class TodoAnnotationTest {
    public static void main(String[] args) {
        Method[] methods = ProjectFeatures.class.getDeclaredMethods();

        System.out.println("--- Pending Tasks ---");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task: " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority: " + todo.priority());
                System.out.println("---------------------");
            }
        }
    }
}
