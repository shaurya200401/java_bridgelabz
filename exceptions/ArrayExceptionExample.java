package exceptions;

import java.util.Scanner;

/**
 * Program 4: Multiple Catch Blocks
 * 
 * Problem Statement:
 * Create a Java program that performs array operations.
 * Accept an integer array and an index number.
 * Retrieve and print the value at that index.
 * Handle ArrayIndexOutOfBoundsException and NullPointerException.
 */
public class ArrayExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define an array
        int[] numbers = { 10, 20, 30, 40, 50 };
        int[] nullArray = null; // For NullPointerException demo

        System.out.println("Select scenario:");
        System.out.println("1. Use Valid Array");
        System.out.println("2. Use Null Array");
        int choice = scanner.nextInt();

        int[] selectedArray = (choice == 2) ? nullArray : numbers;

        System.out.print("Enter index to access: ");
        int index = scanner.nextInt();

        try {
            // Attempt to access array element
            // This might throw NullPointerException if selectedArray is null
            // or ArrayIndexOutOfBoundsException if index is invalid
            System.out.println("Value at index " + index + ": " + selectedArray[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid index
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handle null array
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
