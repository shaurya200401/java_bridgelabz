package regexAndJUnit.regex;

import java.util.regex.*;

public class UserValidator {
    public static void main(String[] args) {
        String[] usernames = { "user_123", "123user", "us", "valid_user", "invalid-user" };

        // Rule: Start with letter, alphanumeric or underscore, length 5-15
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("1. Username Validation:");
        for (String user : usernames) {
            Matcher matcher = pattern.matcher(user);
            if (matcher.matches()) {
                System.out.println("✅ " + user + " -> Valid");
            } else {
                System.out.println("❌ " + user + " -> Invalid");
            }
        }
    }
}
