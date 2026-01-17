package String.level1;

import java.util.Scanner;

/*
 * Program: Manual Substring
 * Purpose: Extracts a substring manually and verifies with built-in .substring().
 */
public class Substring {

    // Method to extract substring manually
    public static String getManualSubstring(String text, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) {
            sub += text.charAt(i);
        }
        return sub;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        System.out.print("Enter start and end index: ");
        int start = sc.nextInt();
        int end = sc.nextInt();

        // Compare results
        String manual = getManualSubstring(text, start, end);
        String builtIn = text.substring(start, end);

        System.out.println("Manual: " + manual + " | Built-in: " + builtIn);
        System.out.println("Comparison: " + manual.equals(builtIn));
        sc.close();
    }
}
