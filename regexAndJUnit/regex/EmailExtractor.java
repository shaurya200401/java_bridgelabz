package regexAndJUnit.regex;

import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for assistance.";

        // Basic Email Regex
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("4. Extracted Emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
