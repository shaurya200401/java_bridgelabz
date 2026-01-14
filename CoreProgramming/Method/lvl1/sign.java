package Method.lvl1;
import java.util.Scanner;

public class sign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Result: " + checkSign(num));
    }

    public static int checkSign(int n) {
        if (n > 0) return 1;
        if (n < 0) return -1;
        return 0;
    }
}
