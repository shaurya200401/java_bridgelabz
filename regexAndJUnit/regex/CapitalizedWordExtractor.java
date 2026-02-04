package regexAndJUnit.regex;

import java.util.regex.*;

public class CapitalizedWordExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Rule: Extract words starting with uppercase
        String regex = "\\b[A-Z][a-zA-Z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("5. Extracted Capitalized Words:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
