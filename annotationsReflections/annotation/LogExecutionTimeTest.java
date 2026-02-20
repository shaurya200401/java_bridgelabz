package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * Problem 3: Create an Annotation for Logging Method Execution Time
 * Problem Statement:
 * Define an annotation @LogExecutionTime to measure method execution time.
 * Requirements:
 * 1. Apply @LogExecutionTime to a method.
 * 2. Use System.nanoTime() before and after execution.
 * 3. Print execution time.
 * 4. Apply it on different methods and compare the time taken.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

/*
 * Class with methods to be timed
 */
class TimedService {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() throws InterruptedException {
        System.out.println("Executing slow method...");
        Thread.sleep(100); // Simulate delay
    }

    public void normalMethod() {
        System.out.println("Executing normal method (not timed)...");
    }
}

/*
 * Main class to execute and time methods
 */
public class LogExecutionTimeTest {
    public static void main(String[] args) {
        TimedService service = new TimedService();
        Method[] methods = TimedService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long start = System.nanoTime();
                    method.invoke(service);
                    long end = System.nanoTime();

                    System.out.println("Execution time for " + method.getName() + ": " + (end - start) + " ns");
                    System.out.println("--------------------------------------------------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
