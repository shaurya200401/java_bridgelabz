package regexAndJUnit.regex;

import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Rule: Extract currency values like $45.99 or 10.50
        // Assumes currency symbol is optional, but decimal is required by example
        // style.
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("13. Extracted Currency Values:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
