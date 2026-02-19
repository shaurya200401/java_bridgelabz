package dataStructures.sorting;

/**
 * Class to sort student ages (10-18) using Counting Sort.
 * Time Complexity: O(n + k) where n is number of elements and k is the range of
 * input
 */
public class CountingSortStudentAges {

    // Method to perform counting sort
    public static void countingSort(int[] ages) {
        int n = ages.length;

        // Find the maximum and minimum age to know the range
        // Problem states ages are 10-18, but let's make it general or stick to range
        int max = 18;
        int min = 10;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[n];

        // Store count of each character
        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Copy the output array to ages, so that ages now
        // contains sorted characters
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] ages = { 15, 12, 14, 18, 10, 13, 14, 11 };

        System.out.println("Unsorted Ages:");
        for (int age : ages)
            System.out.print(age + " ");
        System.out.println();

        countingSort(ages);

        System.out.println("Sorted Ages:");
        for (int age : ages)
            System.out.print(age + " ");
        System.out.println();
    }
}
