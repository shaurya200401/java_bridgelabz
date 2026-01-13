package Arrays.lvl2;

import java.util.Scanner;

public class digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Step 2: Convert number to string to count digits
        String numStr = Long.toString(Math.abs(number)); // handle negative input safely
        int length = numStr.length();

        // Step 3: Store digits in an array
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = numStr.charAt(i) - '0'; // convert char to int
        }

        // Step 4: Frequency array of size 10
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }

        // Step 5: Display frequency of each digit
        System.out.println("\n--- Digit Frequency Report ---");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s).");
            }
        }
    }
}