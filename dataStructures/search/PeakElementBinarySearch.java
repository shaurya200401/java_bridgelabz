package dataStructures.search;

/**
 * Class to find a peak element in an array using Binary Search.
 */
public class PeakElementBinarySearch {

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If arr[mid] < arr[mid + 1], then peak is in the right half
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // If arr[mid] > arr[mid + 1], then peak is in the left half (or mid is peak)
                right = mid;
            }
        }
        // left == right is the peak element index
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        int peak = findPeakElement(arr);
        System.out.println("A peak element is: " + peak);
    }
}
