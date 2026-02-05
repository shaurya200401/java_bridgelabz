package java8Features;

/*
 * Custom functional interface with a single abstract method
 * and a default method.
 */
@FunctionalInterface
interface SquareCalculator {
    // Single Abstract Method (SAM)
    int calculateSquare(int num);

    // Default method: Can be used as is, or overridden by implementing classes
    default void printResult(int result) {
        System.out.println("The square is: " + result);
    }
}

/*
 * Program to demonstrate default methods in a custom functional interface.
 */
public class CustomInterfaceDefaultMethod {
    public static void main(String[] args) {
        // Implementing the abstract method using a lambda expression
        SquareCalculator squarer = n -> n * n;

        int number = 7;
        // Calling the abstract method implementation
        int result = squarer.calculateSquare(number);

        // Calling the default method defined in the interface
        squarer.printResult(result);
    }
}
