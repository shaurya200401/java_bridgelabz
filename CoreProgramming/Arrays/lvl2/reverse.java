package Arrays.lvl2;

import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Error: Not a natural number");
            return;
        }

        // Count digits
        int temp = number;
        int count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int index = 0;
        while (number != 0) {
            digits[index++] = number % 10;
            number /= 10;
        }

        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        System.out.print("Reversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i]);
        }
    }
}