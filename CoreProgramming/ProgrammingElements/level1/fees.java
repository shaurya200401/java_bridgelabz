package ProgrammingElements.level1;

public class fees {
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

