package ControlFLows.lvl2;

import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        // FizzBuzz logic
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0)
                    System.out.println("FizzBuzz");
                else if (i % 3 == 0)
                    System.out.println("Fizz");
                else if (i % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(i);
            }
        } else {
            System.out.println("Not a positive integer");
        }
        sc.close();
    }
}