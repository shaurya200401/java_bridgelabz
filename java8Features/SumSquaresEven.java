package java8Features;

import java.util.Arrays;
import java.util.List;

/*
 * Program to find the sum of squares of all even numbers from a list of integers
 * using Map and Reduce operations with lambda expressions.
 */
public class SumSquaresEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Stream Pipeline:
        // 1. filter: Selects only even numbers
        // 2. map: Transforms each number to its square
        // 3. reduce: Sums up the results
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0) // Lambda to check evenness
                .map(n -> n * n) // Lambda to square the number
                .reduce(0, Integer::sum); // Method reference to sum the values

        System.out.println("List: " + numbers);
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
