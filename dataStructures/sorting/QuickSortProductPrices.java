package dataStructures.sorting;

/**
 * Class to sort product prices using Quick Sort.
 * Time Complexity: O(n log n) average, O(n^2) worst case
 */
public class QuickSortProductPrices {

    // Method to perform quick sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // pi is partitioning index, prices[pi] is now at right place
            int pi = partition(prices, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // This function takes last element as pivot, places
    // the pivot element at its correct position in sorted
    // array, and places all smaller (smaller than pivot)
    // to left of pivot and all greater elements to right
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (prices[j] < pivot) {
                i++;

                // swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // swap prices[i+1] and prices[high] (or pivot)
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] prices = { 10, 7, 8, 9, 1, 5 };

        System.out.println("Unsorted Product Prices:");
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Product Prices:");
        for (int price : prices)
            System.out.print(price + " ");
        System.out.println();
    }
}
