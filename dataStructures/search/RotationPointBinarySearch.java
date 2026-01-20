package dataStructures.search;

/**
 * Class to find the rotation point in a rotated sorted array using Binary
 * Search.
 */
public class RotationPointBinarySearch {

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Perform a binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If arr[mid] > arr[right], then the smallest element is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // If arr[mid] < arr[right], the smallest element is in the left half
                right = mid;
            }
        }
        // Return arr[left] (the rotation point/smallest element)
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int rotationPoint = findRotationPoint(arr);
        System.out.println("The rotation point (minimum element) is: " + rotationPoint);
    }
}
