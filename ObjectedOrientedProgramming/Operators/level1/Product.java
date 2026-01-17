package Operators.level1;

/*
 * Product Class
 * Represents a shopping cart item with discounted pricing.
 * Uses final productID and static discount percentage.
 */
public class Product {
    static double discount = 10.0; // Shared discount percentage
    final String productID; // Immutable ID
    String productName;
    double price;
    int quantity;

    // Constructor
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    public void displayProductInfo() {
        System.out.println("ID: " + productID);
        System.out.println("Product: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Discount Applied: " + discount + "%");
    }

    public static void main(String[] args) {
        Product p1 = new Product("P001", "Wireless Headphones", 199.99, 1);

        // Instanceof check
        if (p1 instanceof Product) {
            p1.displayProductInfo();
        }

        Product.updateDiscount(15.0); // Update global discount
        p1.displayProductInfo(); // Verify update
    }
}
