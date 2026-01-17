package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Integer Operations
 * Purpose: Performs mixed arithmetic operations on three integers input by the user.
 */
public class IntegerOperations {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter c: ");
        int c = sc.nextInt();

        // Perform operations
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.println(
                "The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", " + result4);
        sc.close();
    }

}
