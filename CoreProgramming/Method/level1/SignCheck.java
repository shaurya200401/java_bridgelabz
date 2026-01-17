package Method.level1;

import java.util.Scanner;

/*
 * Program: Number Sign Check
 * Purpose: Determines whether a number is positive (1), negative (-1), or zero (0).
 */
public class SignCheck {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        // Check sign
        System.out.println("Result: " + checkSign(num));
        sc.close();
    }

    public static int checkSign(int n) {
        if (n > 0)
            return 1;
        if (n < 0)
            return -1;
        return 0;
    }
}
