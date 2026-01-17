package ProgrammingElements.level1;

/*
 * Program: Volume of Earth Calculator
 * Purpose: Calculates the volume of the Earth in cubic kilometers and cubic miles given its radius.
 */
public class VolumeofEarth {
    public static void main(String[] args) {
        // Initialize radius
        double radiusKm = 6378;

        // Calculate volume
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles3 = volumeKm3 / Math.pow(1.6, 3);
        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }

}
