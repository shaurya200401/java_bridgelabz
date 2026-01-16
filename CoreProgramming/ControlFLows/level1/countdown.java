package ControlFLows.level1;

import java.util.Scanner;

public class countdown {
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

    }
}
