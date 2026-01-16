package OOPFundamentals.level1;

/*
 * Program: Mobile Phone Details
 * Purpose: Defines a MobilePhone class with attributes (brand, model, price) and display functionality.
 */
public class MobilePhone {
    // Phone attributes
    String brand;
    String model;
    double price;

    // Constructor to initialize MobilePhone
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone specifications
    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create Phone instance
        MobilePhone phone = new MobilePhone("Apple", "iPhone 15", 999.99);
        // Display result
        phone.displayDetails();
    }
}
