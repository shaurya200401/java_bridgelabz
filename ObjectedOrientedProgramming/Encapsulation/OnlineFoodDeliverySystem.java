package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * OnlineFoodDeliverySystem Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * FoodItem is the abstract superclass.
 * Discountable is an interface.
 */
public class OnlineFoodDeliverySystem {

    interface Discountable {
        double applyDiscount(double price);

        String getDiscountDetails();
    }

    static abstract class FoodItem implements Discountable {
        private String itemName;
        private double price;
        private int quantity;

        public FoodItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public abstract double calculateTotalPrice();

        public void getItemDetails() {
            System.out.println("Item: " + itemName + ", Price: $" + price + ", Qty: " + quantity);
            System.out.println("Total Price: $" + calculateTotalPrice());
        }
    }

    static class VegItem extends FoodItem {
        public VegItem(String itemName, double price, int quantity) {
            super(itemName, price, quantity);
        }

        @Override
        public double calculateTotalPrice() {
            double baseTotal = getPrice() * getQuantity();
            return applyDiscount(baseTotal);
        }

        @Override
        public double applyDiscount(double price) {
            // 5% discount for veg items
            return price * 0.95;
        }

        @Override
        public String getDiscountDetails() {
            return "5% Veg Discount";
        }
    }

    static class NonVegItem extends FoodItem {
        public NonVegItem(String itemName, double price, int quantity) {
            super(itemName, price, quantity);
        }

        @Override
        public double calculateTotalPrice() {
            double baseTotal = getPrice() * getQuantity();
            // Additional cooking charge for non-veg?
            baseTotal += 20;
            return applyDiscount(baseTotal);
        }

        @Override
        public double applyDiscount(double price) {
            // No discount for non-veg items usually, or maybe small one
            return price;
        }

        @Override
        public String getDiscountDetails() {
            return "No Discount";
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Tikka", 150, 2));
        order.add(new NonVegItem("Chicken Biryani", 250, 1));

        System.out.println("Order Summary:");
        double grandTotal = 0;
        for (FoodItem item : order) {
            item.getItemDetails();
            grandTotal += item.calculateTotalPrice();
            System.out.println("-------------------------");
        }
        System.out.println("Grand Total: $" + grandTotal);
    }
}
