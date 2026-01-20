package dataStructures.search;

/**
 * Class to find the first negative number in an array using Linear Search.
 */
public class FirstNegativeNumber {

    public static int findFirstNegative(int[] arr) {
        // Iterate through the array from the start
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is negative
            if (arr[i] < 0) {
                // Return its index
                return i;
            }
        }
        // If no negative number is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 5, -3, 8, -1 };
        int index = findFirstNegative(arr);

        if (index != -1) {
            System.out.println("First negative number " + arr[index] + " found at index " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }
}
