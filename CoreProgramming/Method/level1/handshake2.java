package Method.level1;

import java.util.Scanner;

public class handshake2 {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numberOfStudents: ");
        int n = sc.nextInt();
        // Calculate and print proper handshake count
        System.out.println("Possible handshakes: " + ((n * (n - 1)) / 2));
    }
}
