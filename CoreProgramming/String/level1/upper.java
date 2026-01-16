package String.level1;

import java.util.Scanner;

public class upper {
    public static String toUpper(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                res += (char) (ch - 32);
            } else {
                res += ch;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String manual = toUpper(text);
        String builtIn = text.toUpperCase();

        System.out.println("Manual: " + manual + " | Comparison: " + manual.equals(builtIn));
    }
}
