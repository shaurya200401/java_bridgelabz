package dataStructures.sorting;

/**
 * Class to sort book prices using Merge Sort.
 * Time Complexity: O(n log n)
 */
public class MergeSortBookPrices {

    // Main function that sorts prices[l..r] using merge()
    public static void sort(int[] prices, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(prices, l, m);
            sort(prices, m + 1, r);

            // Merge the sorted halves
            merge(prices, l, m, r);
        }
    }

    // Merges two subarrays of prices[]
    public static void merge(int[] prices, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = prices[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = prices[m + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] prices = { 500, 150, 300, 100, 450, 200 };

        System.out.println("Unsorted Prices:");
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();

        sort(prices, 0, prices.length - 1);

        System.out.println("Sorted Prices:");
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();
    }
}
