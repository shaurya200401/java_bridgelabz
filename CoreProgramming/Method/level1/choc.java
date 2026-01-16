package Method.level1;

import java.util.Scanner;

/*
 * Program: Chocolate Distributor
 * Purpose: Calculates how many chocolates each child gets and the remaining chocolates.
 */
public class choc {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numberOfChocolates and numberOfChildren: ");
        int chocolates = sc.nextInt(), children = sc.nextInt();

        // Calculate distribution
        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[1]);
        System.out.println("Remaining chocolates: " + result[0]);
        sc.close();
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[] { number % divisor, number / divisor };
    }
}
