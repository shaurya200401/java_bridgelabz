package Arrays.level1;

import java.util.Scanner;

/*
 * Program: 2D to 1D Array Converter
 * Purpose: Converts a user-input 2D matrix into a 1D array.
 */
public class TwoDArray {
    public static void main(String[] args) {
        // Read dimensions
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        if (rows <= 0 || cols <= 0) {
            System.out.println("Error: Rows and columns must be natural numbers");
            return;
        }

        // Read matrix
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Convert to 1D array
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }

        System.out.print("1D Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}
