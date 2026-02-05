package java8Features;

import java.util.function.Function;

/*
 * Program to calculate the area of a circle using the Function interface.
 * Input: Radius (Double), Output: Area (Double)
 */
public class FunctionAreaCircle {
    public static void main(String[] args) {
        // Defining a Function interface implementation using lambda
        // Function<InputType, OutputType>
        Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;

        double radius = 5.0;

        // Using the apply() method to execute the function
        double area = calculateArea.apply(radius);

        System.out.printf("Area of circle with radius %.2f is %.4f%n", radius, area);
    }
}
