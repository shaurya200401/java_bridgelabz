package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * ECommercePlatform Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * Product is the abstract superclass.
 * Taxable is an interface.
 */
public class ECommercePlatform {

    interface Taxable {
        double calculateTax();

        String getTaxDetails();
    }

    static abstract class Product implements Taxable {
        private int productId;
        private String name;
        private double price;

        public Product(int productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public abstract double calculateDiscount();

        public double calculateFinalPrice() {
            return getPrice() + calculateTax() - calculateDiscount();
        }

        public void displayProductInfo() {
            System.out.println("Product ID: " + productId);
            System.out.println("Name: " + name);
            System.out.println("Price: $" + price);
            System.out.println("Tax: $" + calculateTax() + " (" + getTaxDetails() + ")");
            System.out.println("Discount: $" + calculateDiscount());
            System.out.println("Final Price: $" + calculateFinalPrice());
        }
    }

    static class Electronics extends Product {
        public Electronics(int productId, String name, double price) {
            super(productId, name, price);
        }

        @Override
        public double calculateTax() {
            return getPrice() * 0.18; // 18% tax for electronics
        }

        @Override
        public String getTaxDetails() {
            return "18% GST";
        }

        @Override
        public double calculateDiscount() {
            return getPrice() * 0.10; // 10% discount
        }
    }

    static class Clothing extends Product {
        public Clothing(int productId, String name, double price) {
            super(productId, name, price);
        }

        @Override
        public double calculateTax() {
            return getPrice() * 0.05; // 5% tax for clothing
        }

        @Override
        public String getTaxDetails() {
            return "5% GST";
        }

        @Override
        public double calculateDiscount() {
            return getPrice() * 0.15; // 15% discount
        }
    }

    static class Groceries extends Product {
        public Groceries(int productId, String name, double price) {
            super(productId, name, price);
        }

        @Override
        public double calculateTax() {
            return 0; // No tax for groceries
        }

        @Override
        public String getTaxDetails() {
            return "0% GST";
        }

        @Override
        public double calculateDiscount() {
            return getPrice() * 0.05; // 5% discount
        }
    }

    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();
        cart.add(new Electronics(101, "Laptop", 800));
        cart.add(new Clothing(202, "T-Shirt", 20));
        cart.add(new Groceries(303, "Rice", 10));

        System.out.println("Shopping Cart Details:");
        for (Product p : cart) {
            p.displayProductInfo();
            System.out.println("-------------------------");
        }
    }
}
