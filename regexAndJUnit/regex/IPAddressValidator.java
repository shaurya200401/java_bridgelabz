package regexAndJUnit.regex;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String[] ips = { "192.168.0.1", "255.255.255.255", "256.0.0.1", "123.456.78.90", "1.1.1.1" };

        // Rule: IPv4 address 0-255.0-255.0-255.0-255
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = "^(" + zeroTo255 + "\\.){3}" + zeroTo255 + "$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("10. IP Address Validation:");
        for (String ip : ips) {
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println("✅ " + ip + " -> Valid");
            } else {
                System.out.println("❌ " + ip + " -> Invalid");
            }
        }
    }
}
