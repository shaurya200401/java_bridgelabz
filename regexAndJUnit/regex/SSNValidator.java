package regexAndJUnit.regex;

import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String[] ssns = { "123-45-6789", "123456789", "000-00-0000", "ABC-DE-FGHI" };

        // Rule: 123-45-6789 (3 digits - 2 digits - 4 digits)
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("15. SSN Validation:");
        for (String ssn : ssns) {
            Matcher matcher = pattern.matcher(ssn);
            if (matcher.matches()) {
                System.out.println("✅ " + ssn + " -> Valid");
            } else {
                System.out.println("❌ " + ssn + " -> Invalid");
            }
        }
    }
}
