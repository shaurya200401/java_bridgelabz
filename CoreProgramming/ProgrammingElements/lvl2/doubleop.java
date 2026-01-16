package ProgrammingElements.lvl2;

import java.util.Scanner;

public class doubleop {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        // Perform operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println(
                "The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", " + result4);
    }

}
