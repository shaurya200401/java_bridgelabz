package Constructors.level1;

/*
 * CarRental Class
 * Represents a car rental system.
 * It calculates the total rental cost based on rental days and daily rate.
 */
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final double DAILY_RATE = 50.0; // Fixed daily rate

    // Constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Sarah Connor", "Tesla Model 3", 5);
        rental.displayRentalDetails();
    }
}
