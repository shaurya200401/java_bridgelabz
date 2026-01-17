package Arrays.level1;

import java.util.Scanner;

/*
 * Program: Voting Age Checker
 * Purpose: Checks the voting eligibility for 10 users based on their age.
 */
public class Voting {
    public static void main(String[] args) {
        // Check voting age
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ages:");
        for (int i = 0; i < 10; i++) {
            int age = sc.nextInt();
            if (age < 0)
                System.out.println("Invalid age");
            else if (age >= 18)
                System.out.println("The student with age " + age + " can vote");
            else
                System.out.println("The student with age " + age + " cannot vote");
        }
        sc.close();
    }
}
