package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Largest/Smallest Number Checker
 * Purpose: Identifies which of the three numbers is the largest or smallest.
 */
public class comparenum2 {
    public static void main(String[] args) {
        // Read inputs
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // Compare numbers
        if (num1 > num2 && num1 > num3)
            System.out.println("Is the first number the largest? Yes");
        if (num2 > num1 && num2 > num3)
            System.out.println("Is the second number the largest? Yes");
        else
            System.out.println("Is the third number the smallest? Yes");

        sc.close();
    }
}
