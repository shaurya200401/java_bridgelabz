package String.Extras;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string 1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter string 2: ");
        String str2 = sc.nextLine();

        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        boolean areAnagrams = false;

        if (str1.length() == str2.length()) {
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if (Arrays.equals(arr1, arr2)) {
                areAnagrams = true;
            }
        }

        if (areAnagrams) {
            System.out.println("The strings are anagrams of each other.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }
        sc.close();
    }
}
