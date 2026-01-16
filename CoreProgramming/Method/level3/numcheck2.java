package Method.level3;

public class numcheck2 {
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
        int sum = sumDigits(numcheck1.getDigitsArray(n));
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
        int[] digits = numcheck1.getDigitsArray(num);
        // Check Harshad and frequencies
        System.out.println("Is Harshad: " + isHarshad(num));
        int[][] freq = getDigitFrequency(digits);
        System.out.println("Digit Frequencies:");
        for (int[] f : freq)
            if (f[1] > 0)
                System.out.println(f[0] + " occurs " + f[1] + " times");
    }
}
