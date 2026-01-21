package dataStructures.algorithmRuntimeAnalysis;

import java.util.Arrays;
import java.util.Random;

/**
 * Program to compare the performance of Bubble Sort, Merge Sort, and Quick
 * Sort.
 * Note: Bubble Sort is skipped for 1,000,000 elements as it is unfeasible.
 */
public class SortingPerformanceComparison {

    public static void main(String[] args) {
        int[] datasetSizes = { 1000, 10000, 100000 }; // Reduced max for Bubble Sort feasibility in test, but requested
                                                      // 1,000,000.
        // User requirements: 1,000,000 for merge/quick, but Bubble is unfeasible.
        // We will run specific checks.

        int[] sizes = { 1000, 10000, 1000000 };

        System.out.printf("%-20s %-25s %-25s %-25s%n", "Dataset Size (N)", "Bubble Sort (ms)", "Merge Sort (ms)",
                "Quick Sort (ms)");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] data = generateRandomArray(size);

            String bubbleTimeStr = "Unfeasible";

            // Only run Bubble Sort for smaller datasets
            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(data, data.length);
                long startTime = System.nanoTime();
                bubbleSort(bubbleData);
                long endTime = System.nanoTime();
                double time = (endTime - startTime) / 1_000_000.0;
                bubbleTimeStr = String.format("%.4f", time);
            }

            // Merge Sort
            int[] mergeData = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long endTime = System.nanoTime();
            double mergeTime = (endTime - startTime) / 1_000_000.0;

            // Quick Sort
            int[] quickData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            endTime = System.nanoTime();
            double quickTime = (endTime - startTime) / 1_000_000.0;

            System.out.printf("%-20d %-25s %-25.4f %-25.4f%n", size, bubbleTimeStr, mergeTime, quickTime);
        }
    }

    // Bubble Sort: O(N^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort: O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort: O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }
}
