package Method.level3;

/*
 * Program: Number Operations Utility II
 * Purpose: Checks number properties including sum of digits, sum of squares, and Harshad number status.
 * Also computes frequency of each digit.
 */
public class NumberOperations2 {
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d;
        return sum;
    }

    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits)
            sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int n) {
        int sum = sumDigits(NumberOperations.getDigitsArray(n));
        return n % sum == 0;
    }

    public static int[][] getDigitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++)
            freq[i][0] = i;
        for (int d : digits)
            freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int num = 21;
        int[] digits = NumberOperations.getDigitsArray(num);
        // Check Harshad and frequencies
        System.out.println("Is Harshad: " + isHarshad(num));
        int[][] freq = getDigitFrequency(digits);
        System.out.println("Digit Frequencies:");
        for (int[] f : freq)
            if (f[1] > 0)
                System.out.println(f[0] + " occurs " + f[1] + " times");
    }
}
