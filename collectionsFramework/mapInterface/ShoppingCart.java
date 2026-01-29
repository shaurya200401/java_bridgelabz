package collectionsFramework.mapInterface;

import java.util.*;

/**
 * Shopping Cart Implementation.
 * - HashMap: Store product prices (Product -> Price).
 * - LinkedHashMap: Maintain order of items added.
 * - TreeMap: Display items sorted by price using a Value Comparator.
 */
public class ShoppingCart {

    public static void main(String[] args) {
        // 1. HashMap for random access
        Map<String, Double> productPrices = new HashMap<>();

        // 2. LinkedHashMap for insertion order
        Map<String, Double> cart = new LinkedHashMap<>();

        // Adding items
        addItem(cart, productPrices, "Laptop", 1200.00);
        addItem(cart, productPrices, "Mouse", 25.50);
        addItem(cart, productPrices, "Keyboard", 75.00);
        addItem(cart, productPrices, "Monitor", 300.00);

        System.out.println("Cart (Insertion Order): " + cart);

        // 3. TreeMap sorted by Price (Values)
        // Note: TreeMap typically sorts by Keys. To sort by values, we often need a
        // custom approach
        // or a sorted Set of Entries. A TreeMap with a custom comparator on Keys cannot
        // access Values easily
        // without an external reference.
        // A common pattern to "Display items sorted by price" is to dump entries into a
        // List or TreeSet.
        // Here we will use a List and sort it, then put into a LinkedHashMap for
        // display,
        // OR use a Comparator that accesses the map values (somewhat tricky/brittle).
        // Safest approach for "Display": Sort the entries.
        System.out.println("Cart (Sorted by Price):");
        printSortedByValue(cart);
    }

    private static void addItem(Map<String, Double> cart, Map<String, Double> priceDb, String item, double price) {
        priceDb.put(item, price);
        cart.put(item, price);
    }

    private static void printSortedByValue(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        // Sort by value (Price)
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}
