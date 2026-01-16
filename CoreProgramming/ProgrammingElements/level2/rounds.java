package ProgrammingElements.lvl2;

import java.util.Scanner;

public class rounds {
    public static void main(String[] args) {
        // Take user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side2: ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side3: ");
        double side3 = sc.nextDouble();

        // Calculate perimeter and rounds
        double perimeter = side1 + side2 + side3;
        double distance = 5000; // 5 km in meters
        double rounds = distance / perimeter;

        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }

}
