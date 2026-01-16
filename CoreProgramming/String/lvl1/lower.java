package String.lvl1;

import java.util.Scanner;

public class lower {
    public static String toLower(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                res += (char) (ch + 32);
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

        String manual = toLower(text);
        String builtIn = text.toLowerCase();

        System.out.println("Manual: " + manual + " | Comparison: " + manual.equals(builtIn));
    }
}