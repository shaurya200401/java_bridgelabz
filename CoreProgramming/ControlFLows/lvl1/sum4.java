package ControlFLows.lvl1;
import java.util.Scanner;

public class sum4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a natural number: ");
        int p = sc.nextInt();
        if (p >= 0) {
            int sumFormula = p * (p + 1) / 2;
            int sumFor = 0;
            for (int i = 1; i <= p; i++) {
                sumFor += i;
            }
            System.out.println("Formula result: " + sumFormula);
            System.out.println("For loop result: " + sumFor);
        } else {
            System.out.println("Not a natural number");
        }

    }
}