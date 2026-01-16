package Extras;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Program: Time Zone Display
 * Purpose: Displays the current date and time for different specified time zones.
 */
public class TimeZones {
    public static void main(String[] args) {
        // Define zones
        String[] zones = { "UTC", "Asia/Kolkata", "America/New_York", "Europe/London", "Asia/Tokyo" };
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        System.out.println("Current Time in Different Zones:");

        // Loop through zones and print time
        for (String zone : zones) {
            ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(zone));
            System.out.printf("%-20s : %s%n", zone, zdt.format(formatter));
        }
    }
}
