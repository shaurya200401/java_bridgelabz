package dataStructures.search;

/**
 * Class to find the first and last occurrence of an element in a sorted array
 * using Binary Search.
 */
public class FirstLastOccurrence {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    private static int findLast(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
