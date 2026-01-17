package ControlFLows.level1;

import java.util.Scanner;

/*
 * Program: Countdown Timer
 * Purpose: Counts down from a user-specified value to 1 using a while loop.
 */
public class Countdown {
    public static void main(String[] args) {
        // Read start value
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter countdown start value: ");
        int counter = sc.nextInt();

        // Countdown loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        System.out.println("Rocket Launched!");
        sc.close();
    }
}
