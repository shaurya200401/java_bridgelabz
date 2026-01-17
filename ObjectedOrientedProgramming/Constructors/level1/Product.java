package Constructors.level1;
/*
 * Product Class
 * Demonstrates the difference between instance variables and class variables.
 * Tracks the total number of products created.
 */
public class Product {
    String productName;
    double price;
    static int totalProducts = 0; // Class variable shared by all instances

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products for every new instance
    }

    // Instance method
    public void displayProductDetails() {
        System.out.println("Product: " + productName + ", Price: $" + price);
    }

    // Class method
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Mouse", 25.00);
        Product p3 = new Product("Keyboard", 45.00);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        // Display total products using the class method
        Product.displayTotalProducts();
    }
}
