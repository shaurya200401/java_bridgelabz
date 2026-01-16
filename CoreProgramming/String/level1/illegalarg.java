package String.level1;

/*
 * Program: IllegalArgument Exception Handling
 * Purpose: Demonstrates handling of exceptions related to invalid arguments for operations.
 */
public class illegalarg {

    // Method to generate exception
    public static void generate(String s) {
        // This will cause exception if start > end
        System.out.println(s.substring(5, 2));
    }

    // Method to handle exception
    public static void handle(String s) {
        try {
            System.out.println(s.substring(5, 2));
        } catch (IllegalArgumentException | StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: Invalid arguments for substring.");
        }
    }

    public static void main(String[] args) {
        String text = "JavaProgramming";
        handle(text);
    }
}
