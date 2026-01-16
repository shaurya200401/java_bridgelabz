package OOPFundamentals.level1;

/*
 * Program: Inventory Item Tracker
 * Purpose: Defines an Item class to manage item details and calculate total cost for quantities.
 */
public class Item {
    // Item attributes
    int itemCode;
    String itemName;
    double price;

    // Constructor to initialize Item
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item info
    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: $" + price);
    }

    // Method to calculate cost for N items
    public void calculateTotalCost(int quantity) {
        double total = price * quantity;
        System.out.println("Total Cost for " + quantity + " items: $" + total);
    }

    public static void main(String[] args) {
        // Create Item instance
        Item item = new Item(101, "Laptop", 750.50);
        // Display details and cost
        item.displayDetails();
        item.calculateTotalCost(3);
    }
}
