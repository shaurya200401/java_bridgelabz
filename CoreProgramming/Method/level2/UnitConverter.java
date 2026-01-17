package Method.level2;

/*
 * Program: Unit Converter (Length)
 * Purpose: Provides methods to convert between Kilometers <-> Miles and Meters <-> Feet.
 */
public class UnitConverter {
    // Unit conversion methods
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double m) {
        return m * 3.28084;
    }

    public static double convertFeetToMeters(double ft) {
        return ft * 0.3048;
    }
}
