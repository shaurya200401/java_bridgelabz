package dataStructures.sorting;

/**
 * Class to sort job applicants by salary using Heap Sort.
 * Time Complexity: O(n log n)
 */
public class HeapSortJobApplicants {

    // Method to perform heap sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(salaries, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in salaries[]. n is size of heap
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && salaries[l] > salaries[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && salaries[r] > salaries[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = { 50000, 80000, 45000, 90000, 60000 };

        System.out.println("Unsorted Salaries:");
        for (int salary : salaries)
            System.out.print(salary + " ");
        System.out.println();

        heapSort(salaries);

        System.out.println("Sorted Salaries:");
        for (int salary : salaries)
            System.out.print(salary + " ");
        System.out.println();
    }
}
