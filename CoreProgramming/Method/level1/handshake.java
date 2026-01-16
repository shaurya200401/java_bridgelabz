package Method.level1;

import java.util.Scanner;

/*
 * Program: Handshake Calculator
 * Purpose: Calculates the maximum number of handshakes possible among N students using the formula (n * (n - 1)) / 2.
 */
public class handshake {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Calculate handshakes
        int result = calculateHandshakes(n);
        System.out.println("The maximum number of possible handshakes is: " + result);
        sc.close();
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
