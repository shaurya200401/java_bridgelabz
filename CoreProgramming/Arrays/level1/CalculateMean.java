package Arrays.level1;

import java.util.Scanner;

/*
 * Program: Mean Height Calculator
 * Purpose: Calculates the mean height of 11 football players.
 */
public class CalculateMean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize array for heights
        double[] heights = new double[11];
        double sum = 0.0;

        // Take input for heights
        System.out.println("Enter the heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Calculate sum
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Calculate mean
        double mean = sum / heights.length;

        System.out.println("\nMean height of the football team = " + mean);
        sc.close();
    }
}
