package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * Program to filter a list of strings based on multiple conditions
 * (length greater than 5 AND containing a specific substring)
 * using Predicate composition.
 */
public class PredicateCompositionFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grapefruit", "cherry", "strawberry",
                "blueberry");

        // Defining Predicates
        // Condition 1: String length must be greater than 5
        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;

        // Condition 2: String must contain the substring "berry"
        Predicate<String> containsBerry = s -> s.contains("berry");

        // Composing predicates using the 'and()' default method
        // result = condition1 AND condition2
        Predicate<String> combinedCondition = lengthGreaterThan5.and(containsBerry);

        // Applying the compound predicate to the stream
        List<String> result = words.stream()
                .filter(combinedCondition)
                .collect(Collectors.toList());

        System.out.println("Words > 5 chars and containing 'berry': " + result);
    }
}
