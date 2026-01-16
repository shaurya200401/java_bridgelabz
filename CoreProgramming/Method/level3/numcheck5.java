package Method.level3;

public class numcheck5 {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                factors[index++] = i;
        return factors;
    }

    public static int getGreatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int f : factors)
            sum += f;
        return sum;
    }

    public static boolean isPerfect(int n) {
        int sumProperDivisors = sumFactors(getFactors(n)) - n;
        return sumProperDivisors == n;
    }

    public static boolean isStrong(int n) {
        int[] digits = numcheck1.getDigitsArray(n);
        int totalSum = 0;
        for (int d : digits) {
            int fact = 1;
            for (int i = 1; i <= d; i++)
                fact *= i;
            totalSum += fact;
        }
        return totalSum == n;
    }

    public static void main(String[] args) {
        int num = 145;
        // Verify Strong and Perfect numbers
        System.out.println(num + " is Strong: " + isStrong(num));
        System.out.println("6 is Perfect: " + isPerfect(6));
    }
}
