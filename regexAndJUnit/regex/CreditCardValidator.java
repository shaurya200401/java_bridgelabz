package regexAndJUnit.regex;

import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        String[] cards = { "4123456789123456", "5123456789123456", "3123456789123456", "4123" };

        Pattern visa = Pattern.compile("^4[0-9]{15}$");
        Pattern masterCard = Pattern.compile("^5[0-9]{15}$");

        System.out.println("11. Credit Card Validation:");
        for (String card : cards) {
            String type = "Invalid";
            if (visa.matcher(card).matches()) {
                type = "Valid Visa";
            } else if (masterCard.matcher(card).matches()) {
                type = "Valid MasterCard";
            }
            System.out.println(card + " -> " + type);
        }
    }
}
