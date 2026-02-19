package annotationsReflections.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/*
 * PROBLEM: Dynamic Method Invocation
 * Problem Statement:
 * Define a class MathOperations with multiple public methods (add, subtract, multiply). 
 * Use Reflection to dynamically call any method based on user input.
 * Concepts Tested:
 *  Method.invoke()
 *  Dynamic method selection
 */
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations ops = new MathOperations();
        Class<?> clazz = ops.getClass();

        System.out.println("Available methods: add, subtract, multiply");
        System.out.print("Enter method name to invoke: ");
        String methodName = scanner.next();

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        try {
            // Get method by name and parameter types
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Invoke method
            int result = (int) method.invoke(ops, a, b);
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
