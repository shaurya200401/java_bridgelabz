package java8Features;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMostFrequentWord {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple cherry banana cherry date";
        System.out.println("Input sequence: " + text);

        // Tokenize and Count
        Map<String, Long> frequencyMap = Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(w -> !w.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Frequencies: " + frequencyMap);

        // Find Second Highest Frequency
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1) // Skip the first (most frequent)
                .findFirst() // Take the next one
                .ifPresentOrElse(
                        e -> System.out
                                .println("Second most frequent word: " + e.getKey() + " (Count: " + e.getValue() + ")"),
                        () -> System.out.println("No second most frequent word found."));
    }
}
