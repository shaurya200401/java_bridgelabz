package String.Extras;

import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        int comparison = 0;
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                comparison = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }

        if (comparison == 0) {
            comparison = len1 - len2;
        }

        if (comparison < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (comparison > 0) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
        sc.close();
    }
}
