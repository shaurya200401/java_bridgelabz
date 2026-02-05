package java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 2: Product Sales Analysis
 * Operations: Filter, Transform, Sort, Top N.
 */
public class ProductSalesAnalysis {

    // Inner DTO class for transformed data
    static class ProductSales {
        String productId;
        double totalRevenue;

        public ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }

        @Override
        public String toString() {
            return "ProductSales{ID='" + productId + "', Revenue=$" + totalRevenue + "}";
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P001", 15, 100.0),
                new Sale("P002", 5, 200.0),
                new Sale("P003", 20, 50.0),
                new Sale("P004", 12, 150.0),
                new Sale("P005", 50, 10.0),
                new Sale("P006", 8, 300.0));

        System.out.println("--- 1. Filter: Quantity > 10 ---");
        sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .forEach(System.out::println);

        System.out.println("\n--- 2. Transform: To ProductSales (Revenue) ---");
        List<ProductSales> productRevenue = sales.stream()
                .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
                .collect(Collectors.toList());
        productRevenue.forEach(System.out::println);

        System.out.println("\n--- 3. Sort: By Revenue Descending ---");
        productRevenue.sort((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue));
        productRevenue.forEach(System.out::println);

        System.out.println("\n--- 4. Top N: Top 5 Products by Revenue ---");
        productRevenue.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}
