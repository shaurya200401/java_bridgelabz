package Arrays.level1;

import java.util.Scanner;

/*
 * Program: Number Store
 * Purpose: Stores up to 10 positive numbers input by the user and calculates their sum.
 */
public class NumStore {
    public static void main(String[] args) {
        // Initialize
        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10]; // array of 10 elements
        double total = 0.0; // sum initialized to 0
        int index = 0; // starting index

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = sc.nextDouble();

            if (num <= 0) {
                break; // stop if 0 or negative
            }
            if (index == 10) {
                System.out.println("Array limit reached (10 values).");
                break; // stop if array is full
            }

            numbers[index] = num;
            index++;
        }

        // Calculate sum
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        System.out.println("\n--- Stored Numbers ---");
        for (int i = 0; i < index; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("Total sum of numbers = " + total);
        sc.close();
    }
}
