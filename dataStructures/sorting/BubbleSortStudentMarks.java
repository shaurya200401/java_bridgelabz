package dataStructures.sorting;

/**
 * Class to sort student marks using Bubble Sort.
 * Time Complexity: O(n^2)
 */
public class BubbleSortStudentMarks {

    // Method to perform bubble sort
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse through all elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (marks[j] > marks[j + 1]) {
                    // Swap if they are in wrong order
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] marks = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Unsorted Marks:");
        for (int mark : marks)
            System.out.print(mark + " ");
        System.out.println();

        bubbleSort(marks);

        System.out.println("Sorted Marks:");
        for (int mark : marks)
            System.out.print(mark + " ");
        System.out.println();
    }
}
