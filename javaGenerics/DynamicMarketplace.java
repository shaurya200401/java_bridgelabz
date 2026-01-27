package javaGenerics;

import java.util.ArrayList;
import java.util.List;

/*
 * Dynamic Online Marketplace
 * Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
 * 
 * This program builds a generic product catalog for an online marketplace supporting
 * varying product types (Books, Clothing, Gadgets) with type safety.
 */

// Category classes
class BookCategory {
    @Override
    public String toString() {
        return "Books";
    }
}

class ClothingCategory {
    @Override
    public String toString() {
        return "Clothing";
    }
}

class GadgetCategory {
    @Override
    public String toString() {
        return "Gadgets";
    }
}

// Generic class Product restricted to specific categories
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

// Main class
public class DynamicMarketplace {

    // Generic method to apply discounts dynamically
    // T extends Product<?> allows passing any Product type
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
        System.out
                .println("Applied " + percentage + "% discount on " + product.getName() + ". New Price: $" + newPrice);
    }

    public static void main(String[] args) {
        // Create products with different categories
        Product<BookCategory> book = new Product<>("Java Generics Guide", 50.00, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Denim Jacket", 120.00, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smart Watch", 250.00, new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("--- Product Catalog ---");
        for (Product<?> p : catalog) {
            System.out.println(p);
        }

        System.out.println("\n--- Applying Discounts ---");
        applyDiscount(book, 10); // 10% off
        applyDiscount(shirt, 20); // 20% off
        applyDiscount(phone, 5); // 5% off

        System.out.println("\n--- Updated Catalog ---");
        for (Product<?> p : catalog) {
            System.out.println(p);
        }
    }
}
