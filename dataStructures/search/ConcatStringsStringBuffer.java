package dataStructures.search;

/**
 * Class to concatenate strings efficiently using StringBuffer.
 */
public class ConcatStringsStringBuffer {

    // Method to concatenate strings using StringBuffer
    public static String concatenateStrings(String[] strings) {
        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Iterate through each string in the array and append it to the StringBuffer
        for (String s : strings) {
            sb.append(s);
        }

        // Return the concatenated string after the loop finishes
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = { "Hello", " ", "World", "!", " ", "This", " ", "is", " ", "StringBuffer" };
        String result = concatenateStrings(strings);

        System.out.println("Concatenated String: " + result);
    }
}
