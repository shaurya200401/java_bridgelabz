package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Program to find the maximum value in a list of integers and return it as an Optional.
 * Demonstrates handling of empty lists using Optional API.
 */
public class OptionalMaxFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 9, 23, 1, 18);
        List<Integer> emptyList = Arrays.asList();

        System.out.println("Testing with numbers list: " + numbers);
        findAndPrintMax(numbers);

        System.out.println("\nTesting with empty list: " + emptyList);
        findAndPrintMax(emptyList);
    }

    /*
     * Helper method to find max and handle the Optional result.
     */
    private static void findAndPrintMax(List<Integer> list) {
        // Using Stream reduction to find the max value
        // Returns an Optional<Integer> because the stream/list might be empty
        Optional<Integer> maxVal = list.stream()
                .reduce(Integer::max);

        // Checking if value is present before accessing it
        if (maxVal.isPresent()) {
            System.out.println("Maximum value is: " + maxVal.get());
        } else {
            System.out.println("List is empty, no maximum value found.");
        }
    }
}
