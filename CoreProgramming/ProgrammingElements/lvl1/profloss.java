package ProgrammingElements.lvl1;

public class profloss {
    public static void main(String[] args) {
        // Initialize prices
        int costPrice = 129;
        int sellingPrice = 191;

        // Calculate profit and percentage
        int profit = sellingPrice - costPrice;
        double profitPercent = (profit * 100.0) / costPrice;
        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice +
                "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercent);
    }

}
