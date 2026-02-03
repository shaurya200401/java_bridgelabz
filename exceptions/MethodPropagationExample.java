package exceptions;

/**
 * Program 8: Exception Propagation in Methods
 * 
 * Problem Statement:
 * Create a Java program with three methods:
 * method1(): Throws an ArithmeticException (10 / 0).
 * method2(): Calls method1().
 * main(): Calls method2() and handles the exception.
 */
public class MethodPropagationExample {

    // method1 that throws ArithmeticException
    public static void method1() {
        System.out.println("Inside method1");
        int result = 10 / 0; // This will cause ArithmeticException
    }

    // method2 that calls method1
    public static void method2() {
        System.out.println("Inside method2");
        method1();
    }

    public static void main(String[] args) {
        System.out.println("Inside main");
        try {
            // Call method2 which calls method1
            method2();
        } catch (ArithmeticException e) {
            // Handle the exception propagated from method1 -> method2 -> main
            System.out.println("Handled exception in main: " + e.toString());
        }
    }
}
