package Arrays.level2;

import java.util.Scanner;

public class height {
    public static void main(String[] args) {
        // Initialize arrays
        Scanner sc = new Scanner(System.in);
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height for " + names[i]);
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
            if (ages[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
            }
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("Youngest Friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + ")");
    }
}
