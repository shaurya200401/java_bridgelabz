package regexAndJUnit.regex;

import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        String[] plates = { "AB1234", "A12345", "XY9876", "12AB34", "ABC1234" };

        // Rule: Starts with 2 uppercase letters, followed by 4 digits.
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("2. License Plate Validation:");
        for (String plate : plates) {
            Matcher matcher = pattern.matcher(plate);
            if (matcher.matches()) {
                System.out.println("✅ " + plate + " -> Valid");
            } else {
                System.out.println("❌ " + plate + " -> Invalid");
            }
        }
    }
}
