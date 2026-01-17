package String.level1;

/*
 * Program: Array Index Out of Bounds
 * Purpose: Demonstrates handling exceptions when accessing invalid array indices.
 */
public class OutofBounds2 {

    // Method to demonstrate exception handling
    public static void handle() {
        String[] names = { "Amar", "Akbar", "Anthony" };
        try {
            System.out.println(names[5]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: Index 5 is out of bounds.");
        }
    }

    public static void main(String[] args) {
        handle();
    }
}
