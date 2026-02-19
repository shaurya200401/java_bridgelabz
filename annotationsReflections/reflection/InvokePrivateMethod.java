package annotationsReflections.reflection;

import java.lang.reflect.Method;

/*
 * PROBLEM: Invoke Private Method
 * Problem Statement:
 * Define a class Calculator with a private method multiply(int a, int b). 
 * Use Reflection to invoke this method and display the result.
 * Concepts Tested:
 *  getDeclaredMethod()
 *  setAccessible(true)
 *  Method.invoke()
 */
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            Class<?> clazz = calc.getClass();

            // Get private method 'multiply' with parameters
            Method method = clazz.getDeclaredMethod("multiply", int.class, int.class);

            // Make private method accessible
            method.setAccessible(true);

            // Invoke method
            System.out.println("Invoking private method multiply(5, 10)...");
            int result = (int) method.invoke(calc, 5, 10);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
