package java8Features;

/**
 * Sale class for Problem 2: Product Sales Analysis.
 * Attributes: productId, quantity, price.
 */
public class Sale {
    private String productId;
    private int quantity;
    private double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sale{ID='" + productId + "', qty=" + quantity + ", price=" + price + "}";
    }
}
