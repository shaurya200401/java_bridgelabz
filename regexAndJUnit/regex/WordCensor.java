package regexAndJUnit.regex;

public class WordCensor {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";

        // Rule: Replace specific bad words with ****
        String masked = input.replaceAll("(?i)\\b(bad|stupid|damn)\\b", "****");

        System.out.println("9. Censored String:");
        System.out.println(masked);
    }
}
