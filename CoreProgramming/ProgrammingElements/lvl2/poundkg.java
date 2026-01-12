package ProgrammingElements.lvl2;
import java.util.Scanner;
public class poundkg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();

        double kilograms = pounds / 2.2;
        System.out.println("The weight of the person in pound is " + pounds + " and in kg is " + kilograms);
    }

}
