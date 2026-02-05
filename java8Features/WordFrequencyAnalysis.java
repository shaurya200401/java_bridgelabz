package java8Features;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyAnalysis {
    public static void main(String[] args) {
        String textCorpus = "Java is a programming language. Java is used for many applications. " +
                "Programming with Java is fun. Java streams are powerful. " +
                "Powerful applications are built with Java.";

        System.out.println("Text Corpus: \n" + textCorpus);

        // 1. Tokenize (remove punctuation, lower case, split)
        // 2. Count frequency
        Map<String, Long> wordCounts = Arrays.stream(textCorpus.toLowerCase().split("\\W+"))
                .filter(w -> !w.isEmpty()) // Remove empty strings from split
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("\nWord Frequencies:");
        wordCounts.forEach((k, v) -> System.out.println(k + ": " + v));

        // 3. Find top N most frequent words
        int n = 3;
        System.out.println("\nTop " + n + " most frequent words:");
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
