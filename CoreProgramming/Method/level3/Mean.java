package Method.level3;

import java.util.Random;

/*
 * Program: Height Statistics Analyzer
 * Purpose: Generates random heights for a football team and calculates mean, shortest, and tallest player stats.
 */
public class Mean {
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        // Generate random heights between 150 and 250
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // (0 to 100) + 150
        }

        // Display stats
        System.out.println("Team Heights (cms): " + java.util.Arrays.toString(heights));
        System.out.println("Sum of Heights: " + findSum(heights));
        System.out.println("Mean Height: " + findMean(heights));
        System.out.println("Shortest Player: " + findShortest(heights));
        System.out.println("Tallest Player: " + findTallest(heights));
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int h : arr)
            sum += h;
        return sum;
    }

    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int h : arr)
            if (h < min)
                min = h;
        return min;
    }

    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int h : arr)
            if (h > max)
                max = h;
        return max;
    }
}
