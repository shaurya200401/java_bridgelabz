package ControlFLows.lvl1;

import java.util.Scanner;

public class vote {
    public static void main(String[] args) {
        // Read age
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter age: ");
        int age = sc.nextInt();

        // Check eligibility
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
    }
}
