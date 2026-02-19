package dataStructures.algorithmRuntimeAnalysis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * Program to compare Array, HashSet, and TreeSet for searching elements.
 */
public class DataStructureSearchPerformanceComparison {

    public static void main(String[] args) {
        int[] sizes = { 1000, 100000, 1000000 };

        System.out.printf("%-20s %-25s %-25s %-25s%n", "Dataset Size (N)", "Array (ms)", "HashSet (ms)",
                "TreeSet (ms)");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            int target = -1; // Not usually found with random generation 0-max_int, but good for test

            // Setup collections (time not measured for setup, only search)
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int val : data) {
                hashSet.add(val);
                treeSet.add(val);
            }

            // Array Search
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            double arrayTime = (endTime - startTime) / 1_000_000.0;

            // HashSet Search
            startTime = System.nanoTime();
            hashSet.contains(target);
            endTime = System.nanoTime();
            double hashSetTime = (endTime - startTime) / 1_000_000.0;

            // TreeSet Search
            startTime = System.nanoTime();
            treeSet.contains(target);
            endTime = System.nanoTime();
            double treeSetTime = (endTime - startTime) / 1_000_000.0;

            System.out.printf("%-20d %-25.4f %-25.4f %-25.4f%n", size, arrayTime, hashSetTime, treeSetTime);
        }
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int i : arr) {
            if (i == target)
                return true;
        }
        return false;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}
