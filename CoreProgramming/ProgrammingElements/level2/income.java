package ProgrammingElements.level2;

import java.util.Scanner;

/*
 * Program: Income Calculator
 * Purpose: Calculates total income by summing up salary and bonus.
 */
public class income {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();

        // Calculate total income
        double income = salary + bonus;
        System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus +
                ". Hence Total Income is INR " + income);
        sc.close();
    }

}
