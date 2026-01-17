package Method.level2;

/*
 * Program: Unit Converter (Length II)
 * Purpose: Provides methods to convert between Yards <-> Feet and Meters <-> Inches.
 */
public class UniConverter2 {
    // Check unit conversions
    public static double convertYardsToFeet(double y) {
        return y * 3;
    }

    public static double convertFeetToYards(double f) {
        return f * 0.333333;
    }

    public static double convertMetersToInches(double m) {
        return m * 39.3701;
    }

    public static double convertInchesToMeters(double i) {
        return i * 0.0254;
    }

    public static double convertInchesToCm(double i) {
        return i * 2.54;
    }
}
