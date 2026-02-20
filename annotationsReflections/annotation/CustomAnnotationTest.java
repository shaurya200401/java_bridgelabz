package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * Exercise 4: Create a Custom Annotation and Use It
 * Problem Statement:
 * Create a custom annotation @TaskInfo to mark tasks with priority and assigned person.
 * Steps:
 * 1. Define an annotation @TaskInfo with fields priority and assignedTo.
 * 2. Apply this annotation to a method in TaskManager class.
 * 3. Retrieve the annotation details using Reflection API.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();

    String assignedTo();
}

/*
 * TaskManager class with annotated method
 */
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void performTask() {
        System.out.println("Performing task...");
    }
}

/*
 * Main class to retrieve annotation
 */
public class CustomAnnotationTest {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("performTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
