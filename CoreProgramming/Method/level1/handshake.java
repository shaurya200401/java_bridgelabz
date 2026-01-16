package Method.level1;

import java.util.Scanner;

public class handshake {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Calculate handshakes
        int result = calculateHandshakes(n);
        System.out.println("The maximum number of possible handshakes is: " + result);
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
