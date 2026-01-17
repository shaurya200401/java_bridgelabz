package ProgrammingElements.level1;

/*
 * Program: Km to Miles Converter (Fixed)
 * Purpose: Converts a fixed distance in kilometers to miles.
 */
public class KmtoMiles {
    public static void main(String[] args) {
        // Initialize km
        double km = 10.8;

        // Convert to miles
        double miles = km / 1.6;
        System.out.println("The distance " + km + " km in miles is " + miles);
    }
}
