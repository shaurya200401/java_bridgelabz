package String.lvl2;

import java.util.Scanner;

// Program to display character types in tabular format
public class CharTypeDisplay {

    // Finds length manually
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

    // Checks character type
    public static String checkCharType(char c) {
        char lower = c;
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

    // Identifies types for all characters
    public static String[][] identifyCharTypes(String text) {
        int len = findLength(text);
        String[][] results = new String[len][2];

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            results[i][0] = String.valueOf(c);
            results[i][1] = checkCharType(c);
        }
        return results;
    }

    // Displays the table
    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();

        String[][] charTypes = identifyCharTypes(text);
        displayTable(charTypes);

        scanner.close();
    }
}
