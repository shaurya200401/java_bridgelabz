package Method.lvl1;

import java.util.Scanner;

public class handshake2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numberOfStudents: ");
        int n = sc.nextInt();
        System.out.println("Possible handshakes: " + ((n * (n - 1)) / 2));
    }
}