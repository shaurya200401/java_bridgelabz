package dataStructures.search;

/**
 * Class to reverse a string using StringBuilder.
 */
public class ReverseStringSb {

    // Method to reverse a string using StringBuilder
    public static String reverseString(String input) {
        // Create a new StringBuilder object
        StringBuilder sb = new StringBuilder(input);

        // Use the reverse() method of StringBuilder
        sb.reverse();

        // Convert the StringBuilder back to a string and return it
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);

        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
    }
}
