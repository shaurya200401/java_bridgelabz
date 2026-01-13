package ControlFLows.lvl1;
import java.util.Scanner;

public class countdown2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter countdown start value: ");
        int counter2 = sc.nextInt();
        for (int i = counter2; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Rocket Launched!");

    }
}