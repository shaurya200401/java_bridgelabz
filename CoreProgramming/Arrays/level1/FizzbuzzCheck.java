package Arrays.level1;

import java.util.Scanner;

/*
 * Program: FizzBuzz
 * Purpose: Prints Fizz for multiples of 3, Buzz for 5, and FizzBuzz for both, up to a given number.
 */
public class FizzbuzzCheck {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Error: Not a positive integer");
            return;
        }

        // Generate FizzBuzz results
        String[] results = new String[number + 1];
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0 && i != 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0 && i != 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        // Display results
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
        sc.close();
    }
}
