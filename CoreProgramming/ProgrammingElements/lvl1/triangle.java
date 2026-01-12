package ProgrammingElements.lvl1;
import java.util.Scanner;
public class triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        double areaCm2 = 0.5 * base * height;
        double areaInches2 = areaCm2 / 6.4516;
        System.out.println("Area in square cm: " + areaCm2 + " and in square inches: " + areaInches2);
    }

}
