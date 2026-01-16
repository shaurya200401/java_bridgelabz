package String.level1;

import java.util.Scanner;

public class outofbound2 {
    public static void handle() {
        String[] names = {"Amar", "Akbar", "Anthony"};
        try {
            System.out.println(names[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: Index 5 is out of bounds.");
        }
    }

    public static void main(String[] args) {
        handle();
    }
}
