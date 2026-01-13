package ControlFLows.lvl1;
import java.util.Scanner;

public class sum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total2 = 0.0;
        while (true) {
            System.out.print("\nEnter a number (0 or negative to stop): ");
            double val = sc.nextDouble();
            if (val <= 0) break;
            total2 += val;
        }
        System.out.println("Total sum = " + total2);
    }
}