package regexAndJUnit.regex;

import java.util.regex.*;

public class RepeatedWordFinder {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";

        // Rule: Find repeating words
        // \b(\w+)\s+\1\b catches immediate repetitions
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        System.out.println("14. Found Repeated Words:");
        while (matcher.find()) {
            System.out.println(matcher.group(1)); // Printing the word that repeated
        }
    }
}
