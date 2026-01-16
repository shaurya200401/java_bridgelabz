package ControlFLows.level3;

import java.util.Scanner;

public class count {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        int count = 0;

        // Handle the case if the user enters 0
        if (number == 0) {
            count = 1;
        } else {
            // Loop until number is not 0
            while (number != 0) {
                number = number / 10; // Remove the last digit
                count++; // Increase count
            }
        }

        System.out.println("Number of digits: " + count);
    }
}
