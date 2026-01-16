package Method.level1;

import java.util.Scanner;

/*
 * Program: Smallest and Largest Number Finder
 * Purpose: Finds the smallest and largest among three integers using Math.min and Math.max.
 */
public class smalllarge {
    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();

        // Find smallest and largest
        int[] results = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + results[0] + ", Largest: " + results[1]);
        sc.close();
    }

    public static int[] findSmallestAndLargest(int n1, int n2, int n3) {
        int smallest = Math.min(n1, Math.min(n2, n3));
        int largest = Math.max(n1, Math.max(n2, n3));
        return new int[] { smallest, largest };
    }
}
