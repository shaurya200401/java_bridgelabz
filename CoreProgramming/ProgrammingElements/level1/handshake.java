package ProgrammingElements.level1;

import java.util.Scanner;

/*
 * Program: Handshake Calculator
 * Purpose: Calculates the maximum number of handshakes possible among N students.
 * Formula: n * (n - 1) / 2
 */
public class handshake {
    public static void main(String[] args) {
        // Take input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Calculate possible handshakes
        int handshakes = (n * (n - 1)) / 2;
        System.out.println("Maximum number of handshakes is " + handshakes);
        input.close();
    }

}
