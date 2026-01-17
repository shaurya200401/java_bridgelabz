package String.level1;

/*
 * Program: NullPointerException Handling
 * Purpose: Demonstrates generating and handling exceptions when accessing null objects.
 */
public class NullPointer {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // This will crash
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Cannot access method on null.");
        }
    }

    public static void main(String[] args) {
        // generateException(); // Uncomment to see abrupt stop
        handleException();
    }
}
