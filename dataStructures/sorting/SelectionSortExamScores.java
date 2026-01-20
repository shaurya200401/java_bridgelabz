package dataStructures.sorting;

/**
 * Class to sort exam scores using Selection Sort.
 * Time Complexity: O(n^2)
 */
public class SelectionSortExamScores {

    // Method to perform selection sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (scores[j] < scores[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = scores[min_idx];
            scores[min_idx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = { 85, 92, 78, 90, 88, 76 };

        System.out.println("Unsorted Exam Scores:");
        for (int score : scores)
            System.out.print(score + " ");
        System.out.println();

        selectionSort(scores);

        System.out.println("Sorted Exam Scores:");
        for (int score : scores)
            System.out.print(score + " ");
        System.out.println();
    }
}
