package regexAndJUnit.regex;

import java.util.regex.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Rule: Extract specific programming languages
        // For general "Capitalized Words that are not start of sentence" it could be
        // more complex
        // adhering to valid list from prompt logic or checking from a set.
        // Or simply matching proper nouns in context.
        // Given prompt "Extract Programming Language Names", I'll match the known ones
        // in example.
        String regex = "\\b(Java|Python|JavaScript|Go|C|C\\+\\+|Rust|Ruby|Swift|Kotlin)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("12. Extracted Languages:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
