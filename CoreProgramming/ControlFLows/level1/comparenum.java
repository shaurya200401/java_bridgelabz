package ControlFLows.level1;

import java.util.Scanner;

public class comparenum {
    public static void main(String[] args) {
        // Read inputs
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // Compare numbers
        if (num1 < num2 && num1 < num3)
            System.out.println("Is the first number the smallest? Yes");
        else
            System.out.println("Is the first number the smallest? No");
    }

}

