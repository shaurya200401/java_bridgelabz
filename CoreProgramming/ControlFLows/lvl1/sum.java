package ControlFLows.lvl1;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        // Calculate sum
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("\nEnter a number (0 to stop): ");
            double val = sc.nextDouble();
            if (val == 0)
                break;
            total += val;
        }
        System.out.println("Total sum = " + total);
    }
}