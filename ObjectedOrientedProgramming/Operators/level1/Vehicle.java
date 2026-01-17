package Operators.level1;

/*
 * Vehicle Class
 * Manages vehicle registration with shared registration fee.
 * Uses final registration number to ensure uniqueness.
 */
public class Vehicle {
    static double registrationFee = 500.00; // Shared fee
    final String registrationNumber; // Immutable ID
    String ownerName;
    String vehicleType;

    // Constructor
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Static method to update fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration Fee Updated to: $" + registrationFee);
    }

    public void displayDetails() {
        System.out.println("Reg No: " + registrationNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Type: " + vehicleType);
        System.out.println("Fee Charged: $" + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("KA-01-AB-1234", "Robert", "SUV");

        // Instanceof check
        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }

        Vehicle.updateRegistrationFee(600.00);
        v1.displayDetails();
    }
}
