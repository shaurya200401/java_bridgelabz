package java8Features;

/*
 * Program to implement a custom functional interface that takes two integer inputs
 * and returns their sum using lambda expressions.
 * This demonstrates the definition and usage of a Functional Interface.
 */
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class FunctionalInterfaceSum {
    public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
        // The lambda (a, b) -> a + b provides the implementation for the abstract
        // method 'operate'
        MathOperation sum = (a, b) -> a + b;

        int num1 = 10;
        int num2 = 20;

        // Calling the method using the lambda implementation
        int result = sum.operate(num1, num2);

        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + result);
    }
}
