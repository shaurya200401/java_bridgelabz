package OOPFundamentals.level2;

/*
 * Program: Shopping Cart Item
 * Purpose: Class to model a cart item and calculate cost based on quantity.
 */
public class CartItem {
    // Cart item attributes
    String itemName;
    double price;
    int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Display item info
    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Calculate total cost
    public double calculateTotalCost() {
        return price * quantity;
    }

    public static void main(String[] args) {
        // Initialize item
        CartItem apple = new CartItem("Apple", 0.50, 10);

        // Modify quantity
        apple.quantity += 5;

        // Show result
        apple.displayDetails();
        System.out.println("Total Cost: $" + apple.calculateTotalCost());
    }
}
