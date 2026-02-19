package dataStructures.sorting;

/**
 * Class to sort employee IDs using Insertion Sort.
 * Time Complexity: O(n^2)
 */
public class InsertionSortEmployeeIDs {

    // Method to perform insertion sort
    public static void insertionSort(int[] ids) {
        int n = ids.length;

        // Traverse through 1 to n
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            // Move elements of ids[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            // Place key at after the element just smaller than it.
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = { 105, 102, 108, 101, 109, 103 };

        System.out.println("Unsorted Employee IDs:");
        for (int id : employeeIDs)
            System.out.print(id + " ");
        System.out.println();

        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIDs)
            System.out.print(id + " ");
        System.out.println();
    }
}
