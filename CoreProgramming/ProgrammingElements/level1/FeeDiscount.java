package ProgrammingElements.level1;

/*
 * Program: Fixed Fee Discount Calculator
 * Purpose: Calculates the discount amount and final fee for a fixed fee and discount percentage.
 */
public class FeeDiscount {
    public static void main(String[] args) {
        // Initialize fee and discount
        double fee = 125000;
        double discountPercent = 10;

        // Calculate discount and final fee
        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }

}
