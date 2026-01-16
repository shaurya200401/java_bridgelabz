package String.Extras;

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256];
        int maxFreq = 0;
        char maxChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
            if (freq[ch] > maxFreq) {
                maxFreq = freq[ch];
                maxChar = ch;
            }
        }

        System.out.println("Most Frequent Character: '" + maxChar + "'");
        sc.close();
    }
}
