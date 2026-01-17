package ObjectedOrientedProgramming.Inheritance;

/*
 * OrderManagement Class
 * Demonstrates multilevel inheritance.
 * Hierarchy: Order -> ShippedOrder -> DeliveredOrder.
 */

public class OrderManagement {

    static class Order {
        String orderId;
        String orderDate;

        public Order(String orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        public String getOrderStatus() {
            return "Order Placed";
        }
    }

    static class ShippedOrder extends Order {
        String trackingNumber;

        public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        @Override
        public String getOrderStatus() {
            return "Order Shipped (Tracking: " + trackingNumber + ")";
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        @Override
        public String getOrderStatus() {
            return "Order Delivered on " + deliveryDate;
        }
    }

    public static void main(String[] args) {
        Order order = new Order("ORD100", "2023-10-01");
        ShippedOrder shipped = new ShippedOrder("ORD101", "2023-10-02", "TRK98765");
        DeliveredOrder delivered = new DeliveredOrder("ORD102", "2023-10-03", "TRK12345", "2023-10-05");

        System.out.println(order.getOrderStatus());
        System.out.println(shipped.getOrderStatus());
        System.out.println(delivered.getOrderStatus());
    }
}
