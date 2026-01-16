package String.level3;

import java.util.Scanner;

/*
 * Program: Unique Character Finder
 * Purpose: Identifies and lists all unique (distinct) characters in a string.
 */
public class UniqueCharacters {

    // Find length manually
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // Finds unique characters using nested loops
    public static char[] findUniqueCharacters(String text) {
        int len = findLength(text);
        char[] unique = new char[len];
        int k = 0;

        for (int i = 0; i < len; i++) {
            boolean isUnique = true;
            char currentChar = text.charAt(i);

            // Check if char already exists in our unique array
            for (int j = 0; j < k; j++) {
                if (unique[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[k++] = currentChar;
            }
        }

        // Resize array to actual count
        char[] result = new char[k];
        System.arraycopy(unique, 0, result, 0, k);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        scanner.close();
    }
}
