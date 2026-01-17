package Method.level1;

import java.util.Scanner;

/*
 * Program: Division Calculator
 * Purpose: Calculates the quotient and remainder of two numbers used in division.
 */
public class DivisionCalc {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number and divisor: ");
        int num = sc.nextInt(), div = sc.nextInt();

        // Calculate quotient and remainder
        int[] result = findRemainderAndQuotient(num, div);
        System.out.println("Quotient: " + result[1] + ", Remainder: " + result[0]);
        sc.close();
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[] { number % divisor, number / divisor };
    }
}
