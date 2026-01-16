package Method.level2;

/*
 * Program: Natural Number Sum (Recursion vs Formula)
 * Purpose: Compares the sum of N natural numbers calculated via recursion and the mathematical formula.
 */
public class natsum {
    public static void main(String[] args) {
        int n = 10; // Sample input
        if (n <= 0)
            System.exit(0);

        // Calculate sum using recursion and formula
        int recursiveResult = sumRecursion(n);
        int formulaResult = sumFormula(n);

        System.out.println("Recursion: " + recursiveResult);
        System.out.println("Formula: " + formulaResult);
        System.out.println("Results match: " + (recursiveResult == formulaResult));
    }

    public static int sumRecursion(int n) {
        if (n == 1)
            return 1;
        return n + sumRecursion(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
}
