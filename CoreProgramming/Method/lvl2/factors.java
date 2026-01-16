package Method.lvl2;

import java.util.Scanner;

public class factors {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] factors = findFactors(num);

        // Display results
        System.out.println("Factors: " + java.util.Arrays.toString(factors));
        System.out.println("Sum: " + findSum(factors));
        System.out.println("Product: " + findProduct(factors));
        System.out.println("Sum of Squares: " + findSumOfSquares(factors));
    }

    public static int[] findFactors(int n) {
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

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int f : arr)
            sum += f;
        return sum;
    }

    public static long findProduct(int[] arr) {
        long prod = 1;
        for (int f : arr)
            prod *= f;
        return prod;
    }

    public static double findSumOfSquares(int[] arr) {
        double sumSq = 0;
        for (int f : arr)
            sumSq += Math.pow(f, 2);
        return sumSq;
    }
}
