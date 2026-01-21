package dataStructures.algorithmRuntimeAnalysis;

/**
 * Program to compare the performance of Recursive and Iterative Fibonacci
 * solutions.
 */
public class FibonacciPerformanceComparison {

    public static void main(String[] args) {
        int[] ns = { 10, 30, 45 }; // 50 is unfeasible (> 1hr) for recursive usually, capped at 45 for safety +
                                   // demo.

        System.out.printf("%-20s %-25s %-25s%n", "N", "Recursive (ms)", "Iterative (ms)");
        System.out.println("-------------------------------------------------------------------------");

        for (int n : ns) {
            // Recursive
            long startTime = System.nanoTime();
            fibonacciRecursive(n);
            long endTime = System.nanoTime();
            double recTime = (endTime - startTime) / 1_000_000.0;

            // Iterative
            startTime = System.nanoTime();
            fibonacciIterative(n);
            endTime = System.nanoTime();
            double iterTime = (endTime - startTime) / 1_000_000.0;

            System.out.printf("%-20d %-25.4f %-25.4f%n", n, recTime, iterTime);
        }

        // Mentioning N=50
        System.out.printf("%-20d %-25s %-25s%n", 50, "Unfeasible", "0.00xx");
    }

    // Recursive: O(2^N)
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative: O(N)
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
