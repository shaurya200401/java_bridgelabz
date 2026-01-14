package Method.lvl1;
import java.util.Scanner;

public class handshake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int result = calculateHandshakes(n);
        System.out.println("The maximum number of possible handshakes is: " + result);
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}