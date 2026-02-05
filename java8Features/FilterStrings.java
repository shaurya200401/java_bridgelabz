package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Program to filter a list of strings starting with the letter "A"
 * using Java 8 lambda expressions and Stream API.
 */
public class FilterStrings {
    public static void main(String[] args) {
        // Creating a list of strings
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apricot", "Cherry", "Avocado", "Blueberry");

        System.out.println("Original List: " + fruits);

        // Usage of Stream API to process the list
        List<String> filteredList = fruits.stream()
                .filter(s -> s.startsWith("A")) // Lambda expression to filter strings starting with 'A'
                .collect(Collectors.toList()); // Collecting results back into a List

        System.out.println("Strings starting with 'A': " + filteredList);
    }
}
