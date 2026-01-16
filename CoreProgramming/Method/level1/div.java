package Method.lvl1;

import java.util.Scanner;

public class div {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number and divisor: ");
        int num = sc.nextInt(), div = sc.nextInt();

        // Calculate quotient and remainder
        int[] result = findRemainderAndQuotient(num, div);
        System.out.println("Quotient: " + result[1] + ", Remainder: " + result[0]);
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[] { number % divisor, number / divisor };
    }
}