package dataStructures.algorithmRuntimeAnalysis;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Program to compare the performance of Linear Search and Binary Search on
 * different dataset sizes.
 * It measures the time taken by each algorithm for 1,000, 10,000, and 1,000,000
 * elements.
 */
public class SearchPerformanceComparison {

    public static void main(String[] args) {
        int[] datasetSizes = { 1000, 10000, 1000000 };

        System.out.printf("%-20s %-25s %-25s%n", "Dataset Size (N)", "Linear Search (ms)", "Binary Search (ms)");
        System.out.println("-------------------------------------------------------------------------");

        for (int size : datasetSizes) {
            int[] data = generateSortedArray(size);
            int target = -1; // Worst case: target not found

            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            double linearTime = (endTime - startTime) / 1_000_000.0;

            // Binary Search
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            double binaryTime = (endTime - startTime) / 1_000_000.0;

            System.out.printf("%-20d %-25.4f %-25.4f%n", size, linearTime, binaryTime);
        }
    }

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search: O(log N) - expects sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Helper to generate sorted array
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
