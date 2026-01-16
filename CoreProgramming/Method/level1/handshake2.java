package Method.level1;

import java.util.Scanner;

/*
 * Program: Handshake Calculator (Direct Print)
 * Purpose: Calculates and prints the maximum number of handshakes for N students directly in the main method.
 */
public class handshake2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numberOfStudents: ");
        int n = sc.nextInt();
        // Calculate and print proper handshake count
        System.out.println("Possible handshakes: " + ((n * (n - 1)) / 2));
        sc.close();
    }
}
