package Extras;

import java.util.Scanner;

/*
 * Program: Maximum of Three Numbers
 * Purpose: Finds the largest of three integers input by the user.
 */
public class MaxOfThree {

    // Helper method to get input
    public static int getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

    // Method to find maximum logic
    public static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get inputs
        int num1 = getInput(sc, "Enter first number: ");
        int num2 = getInput(sc, "Enter second number: ");
        int num3 = getInput(sc, "Enter third number: ");

        // Determine max
        int max = findMax(num1, num2, num3);
        System.out.println("The maximum number is: " + max);
        sc.close();
    }
}
