package annotationsReflections.reflection;

import java.lang.reflect.Method;

/*
 * PROBLEM: Method Execution Timing
 * Problem Statement:
 * Use Reflection to measure the execution time of methods in a given class dynamically.
 * Concepts Tested:
 *  Method invocation wrapper
 *  Performance timing
 */

class Task {
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulate delay
            System.out.println("Slow method executed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fastMethod() {
        System.out.println("Fast method executed.");
    }
}

public class MethodExecutionTimer {
    public static void executeAndMeasure(Object obj, String methodName) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName);

            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();

            double durationMs = (endTime - startTime) / 1_000_000.0;
            System.out.println("Execution time of " + methodName + ": " + durationMs + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();

        System.out.println("Measuring slow method...");
        executeAndMeasure(task, "slowMethod");

        System.out.println("\nMeasuring fast method...");
        executeAndMeasure(task, "fastMethod");
    }
}
