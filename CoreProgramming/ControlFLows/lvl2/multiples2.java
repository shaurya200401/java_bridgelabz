package ControlFLows.lvl2;

import java.util.Scanner;

import java.util.Scanner;

public class multiples2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            int i = 100;
            while (i >= 1) {
                if (i % number == 0) {
                    System.out.println(i);
                }
                i--;
            }
        } else {
            System.out.println("Invalid input");
        }
        sc.close();
    }
}