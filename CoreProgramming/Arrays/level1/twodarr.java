package Arrays.lvl1;

import java.util.Scanner;

public class twodarr {
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
    }
}