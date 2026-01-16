package Extras;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Format 1: dd/MM/yyyy
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Format 1 (dd/MM/yyyy): " + today.format(fmt1));

        // Format 2: yyyy-MM-dd
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Format 2 (yyyy-MM-dd): " + today.format(fmt2));

        // Format 3: EEE, MMM dd, yyyy
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + today.format(fmt3));
    }
}
