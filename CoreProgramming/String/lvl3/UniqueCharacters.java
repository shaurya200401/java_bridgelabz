package CoreProgramming.String.lvl3;

import java.util.Scanner;

// Program to find unique characters in a string
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

            // If unique so far, check if it repeats in the rest of the string?
            // Wait, "Unique" usually means "distinct" (appearing at least once) OR
            // "appearing exactly once"?
            // Prompt says: "Find unique characters... outer loop iterates... inner loop
            // checks if character is unique by comparing it with previous characters".
            // This logic describes finding distinct characters (i.e., 'apple' -> 'a', 'p',
            // 'l', 'e').
            // Let's stick to Distinct characters based on typical "unique chars" problems
            // unless specified "non-repeating".
            // Wait, prompt says "comparing it with the previous characters".

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
