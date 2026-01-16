package ControlFLows.lvl2;

import java.util.Scanner;

public class factors2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Find factors using while loop
        if (number > 0) {
            int i = 1;
            while (i < number) {
                if (number % i == 0)
                    System.out.println(i);
                i++;
            }
        } else {
            System.out.println("Not a positive integer");
        }
        sc.close();
    }
}