package Arrays.level2;

import java.util.Scanner;

/*
 * Program: Digit Frequency Counter
 * Purpose: Counts the frequency of each digit (0-9) in a user-input number.
 */
public class digits {
    public static void main(String[] args) {
        // Read number
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        String numStr = Long.toString(Math.abs(number)); // handle negative input safely
        int length = numStr.length();

        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = numStr.charAt(i) - '0'; // convert char to int
        }

        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }

        System.out.println("\n--- Digit Frequency Report ---");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s).");
            }
        }
        sc.close();
    }
}
