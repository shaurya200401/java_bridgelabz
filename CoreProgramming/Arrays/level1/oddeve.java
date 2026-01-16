package Arrays.level1;

import java.util.Scanner;

/*
 * Program: Odd and Even Separator
 * Purpose: Separates odd and even numbers from 1 to N into respective arrays.
 */
public class oddeve {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Error: Not a natural number");
            return;
        }

        // Initialize arrays
        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];
        int oddIndex = 0, evenIndex = 0;

        // Loop to separate
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }

        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }
        System.out.println();
        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }
        sc.close();
    }
}
