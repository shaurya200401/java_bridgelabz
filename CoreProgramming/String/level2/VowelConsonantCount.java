package String.level2;

import java.util.Scanner;

// Program to count vowels and consonants
public class VowelConsonantCount {

    // Finds string length manually
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

    // Checks if character is Vowel, Consonant or Not a Letter
    public static String checkCharType(char c) {
        char lower = c;
        // Convert to lowercase manually
        if (c >= 'A' && c <= 'Z') {
            lower = (char) (c + 32);
        }

        if (lower >= 'a' && lower <= 'z') {
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Counts vowels and consonants
    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        int len = findLength(text);

        for (int i = 0; i < len; i++) {
            String type = checkCharType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsConsonants(text);

        System.out.println("Vowels count: " + counts[0]);
        System.out.println("Consonants count: " + counts[1]);

        scanner.close();
    }
}

