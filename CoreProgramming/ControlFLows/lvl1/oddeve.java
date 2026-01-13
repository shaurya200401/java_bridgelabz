package ControlFLows.lvl1;
import java.util.Scanner;

public class oddeve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a natural number: ");
        int limit = sc.nextInt();
        if (limit >= 1) {
            for (int i = 1; i <= limit; i++) {
                if (i % 2 == 0) System.out.println(i + " is Even");
                else System.out.println(i + " is Odd");
            }
        } else {
            System.out.println("Not a natural number");
        }
    }
}