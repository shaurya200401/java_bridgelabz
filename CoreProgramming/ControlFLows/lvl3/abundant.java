package ControlFLows.lvl3;
import java.util.Scanner;

public class abundant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        int sum = 0;

        // Find divisors from 1 up to (number - 1)
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i; // Add divisor to sum
            }
        }

        // Check if sum is greater than the original number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is Not an Abundant Number.");
        }
    }
}