package regexAndJUnit.regex;

public class SpaceCleaner {
    public static void main(String[] args) {
        String input = "This is    an example    with    multiple spaces.";

        // Rule: Replace multiple spaces with a single space
        String output = input.replaceAll("\\s+", " ");

        System.out.println("8. Cleaned String:");
        System.out.println(output);
    }
}
