package String.lvl1;

import java.util.Scanner;

public class numfor {
    public static void generate(String s) {
        int num = Integer.parseInt(s);
    }

    public static void handle(String s) {
        try {
            int num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Text is not a valid number.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to convert to int: ");
        String text = sc.next();
        handle(text);
    }
}