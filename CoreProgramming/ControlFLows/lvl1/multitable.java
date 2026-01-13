package ControlFLows.lvl1;
import java.util.Scanner;

public class multitable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number: ");
        int tableNum = sc.nextInt();
        for (int i = 6; i <= 9; i++) {
            System.out.println(tableNum + " * " + i + " = " + (tableNum * i));
        }

        sc.close();
    }
}

