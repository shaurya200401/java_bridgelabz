package Method.level3;

public class numcheck3 {
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++)
            reversed[i] = digits[digits.length - 1 - i];
        return reversed;
    }

    public static boolean areArraysEqual(int[] a, int[] b) {
        return java.util.Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int n) {
        int[] original = numcheck1.getDigitsArray(n);
        // Reverse array to check palindrome
        int[] reversed = reverseArray(original);
        return areArraysEqual(original, reversed);
    }

    public static void main(String[] args) {
        int num = 121;
        System.out.println(num + " is Palindrome: " + isPalindrome(num));
    }
}
