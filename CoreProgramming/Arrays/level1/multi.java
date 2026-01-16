package Arrays.lvl1;

import java.util.Scanner;

public class multi {
    public static void main(String[] args) {
        // Step 1: Get user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to print its multiplication table: ");
        int number = sc.nextInt();

        // Step 2: Define an array to store results (1 to 10)
        int[] table = new int[10];

        // Step 3: Run a loop to calculate and store results
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Step 4: Display the results
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }

        sc.close();
    }
}
