package ProgrammingElements.lvl2;

import java.util.Scanner;

public class travel {
    public static void main(String[] args) {
        // Take inputs
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter From City: ");
        String fromCity = sc.nextLine();

        System.out.print("Enter Via City: ");
        String viaCity = sc.nextLine();

        System.out.print("Enter To City: ");
        String toCity = sc.nextLine();

        System.out.print("Enter distance from FromCity to ViaCity (in miles): ");
        double fromToVia = sc.nextDouble();

        System.out.print("Enter distance from ViaCity to ToCity (in miles): ");
        double viaToFinalCity = sc.nextDouble();

        System.out.print("Enter time taken (in hours): ");
        double time = sc.nextDouble();

        // Calculate total distance and speed
        double totalDistance = fromToVia + viaToFinalCity;
        double speed = totalDistance / time;

        System.out.println("Traveler: " + name);
        System.out.println("Route: " + fromCity + " → " + viaCity + " → " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time Taken: " + time + " hours");
        System.out.println("Average Speed: " + speed + " miles/hour");
    }

}
