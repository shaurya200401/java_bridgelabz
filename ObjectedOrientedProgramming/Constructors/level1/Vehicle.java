package Constructors.level1;
/*
 * Vehicle Class
 * Manages vehicle details and a common registration fee.
 * Demonstrates static method to update the shared fee.
 */
public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0; // Fixed for all vehicles initially

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    public void displayVehicleDetails() {
        System.out
                .println("Owner: " + ownerName + ", Type: " + vehicleType + ", Registration Fee: $" + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration Fee updated to: $" + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Sedan");
        Vehicle v2 = new Vehicle("Bob", "SUV");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(600.0);

        v1.displayVehicleDetails(); // Fee updated for all
        v2.displayVehicleDetails(); // Fee updated for all
    }
}
