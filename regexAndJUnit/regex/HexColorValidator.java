package regexAndJUnit.regex;

import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        String[] colors = { "#FFA500", "#ff4500", "#123", "#G12345", "#123456" };

        // Rule: Starts with #, followed by 6 hex chars (0-9, A-F, a-f)
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("3. Hex Color Validation:");
        for (String color : colors) {
            Matcher matcher = pattern.matcher(color);
            if (matcher.matches()) {
                System.out.println("✅ " + color + " -> Valid");
            } else {
                System.out.println("❌ " + color + " -> Invalid");
            }
        }
    }
}
