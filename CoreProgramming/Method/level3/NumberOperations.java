package Method.level3;

/*
 * Program: Number Operations Utility I
 * Purpose: Provides methods to handle digit operations like count, extraction, and finding min/max digits.
 * Also checks for Duck Number and Armstrong Number.
 */
public class NumberOperations {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    public static int[] getDigitsArray(int n) {
        int len = countDigits(n);
        int[] digits = new int[len];
        n = Math.abs(n);
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits)
            if (d != 0)
                return true; // Has a non-zero digit
        return false;
    }

    public static boolean isArmstrong(int n) {
        int[] digits = getDigitsArray(n);
        int len = digits.length;
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, len);
        return sum == n;
    }

    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest)
                secondLargest = d;
        }
        System.out.println("Largest: " + largest + ", Second Largest: " + secondLargest);
    }

    public static void findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest)
                secondSmallest = d;
        }
        System.out.println("Smallest: " + smallest + ", Second Smallest: " + secondSmallest);
    }

    public static void main(String[] args) {
        int num = 153;
        // Verify number properties
        int[] digits = getDigitsArray(num);
        System.out.println("Number: " + num);
        System.out.println("Is Armstrong: " + isArmstrong(num));
        findLargestAndSecondLargest(digits);
        findSmallestAndSecondSmallest(digits);
    }
}
