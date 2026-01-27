package javaGenerics;

import java.util.ArrayList;
import java.util.List;

/*
 * Smart Warehouse Management System
 * Concepts: Generic Classes, Bounded Type Parameters, Wildcards
 * 
 * This program demonstrates a warehouse system that manages different types of items
 * (Electronics, Groceries, Furniture) using generics for type safety and wildcards
 * for flexible list processing.
 */

// Abstract class representing a generic item in the warehouse
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

// Subclass for Electronics
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

// Subclass for Groceries
class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

// Subclass for Furniture
class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

// Generic class to store items ensuring type safety
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName());
    }

    public List<T> getItems() {
        return items;
    }
}

// Main class
public class SmartWarehouseSystem {

    // Wildcard method to display items from any storage of WarehouseItem subtypes
    public static void displayInventory(List<? extends WarehouseItem> items) {
        System.out.println("Processing Inventory:");
        for (WarehouseItem item : items) {
            System.out.println("- " + item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create storage for different types
        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop", 1200.00));
        electronicStorage.addItem(new Electronics("Smartphone", 800.00));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 20.00));
        groceryStorage.addItem(new Groceries("Wheat", 15.00));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Sofa", 500.00));
        furnitureStorage.addItem(new Furniture("Table", 150.00));

        System.out.println("\n--- Warehouse Inventory ---");
        displayInventory(electronicStorage.getItems());
        displayInventory(groceryStorage.getItems());
        displayInventory(furnitureStorage.getItems());
    }
}
