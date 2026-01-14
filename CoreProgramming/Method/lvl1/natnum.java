package Method.lvl1;

import java.util.Scanner;

public class natnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Sum of " + n + " natural numbers: " + findSum(n));
    }

    public static int findSum(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) total += i;
        return total;
    }
}