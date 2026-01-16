package ControlFLows.lvl1;

import java.util.Scanner;

public class div5 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();

        // Check divisibility
        if (num % 5 == 0)
            System.out.println("Is the " + num + " divisible by 5? " + "Yes");
        else
            System.out.println("Is the " + num + " divisible by 5? " + "No");
    }
}
