package ProgrammingElements.lvl1;

import java.util.Scanner;

public class kmtomiles2 {
    public static void main(String[] args) {
        // Take input for km
        Scanner input = new Scanner(System.in);
        double km;
        System.out.print("Enter distance in km: ");
        km = input.nextDouble();

        // Convert to miles
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }

}
