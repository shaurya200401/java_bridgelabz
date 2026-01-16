package Arrays.lvl1;

import java.util.Scanner;

public class posneg {
    public static void main(String[] args) {
        // Read numbers
        Scanner sc = new Scanner(System.in);
        System.out.println("enter numbers:");
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        // Check conditions for each number
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0)
                System.out.println(num + " is a negative number");
            if (num > 0) {
                System.out.println(num + " is a positive number");
                if (num % 2 == 0)
                    System.out.println(num + " is an even number");
                else
                    System.out.println(num + " is an odd number");
            } else
                System.out.println("number is 0");
        }

    }
}
