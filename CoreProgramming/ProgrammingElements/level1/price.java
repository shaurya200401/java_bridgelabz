package ProgrammingElements.lvl1;

import java.util.Scanner;

public class price {

    public static void main(String[] args) {
        // Input price and quantity
        Scanner input = new Scanner(System.in);
        System.out.print("Enter unit price: ");
        double unitPrice = input.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        // Calculate total
        double total = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity
                + " and unit price is INR " + unitPrice);
    }
}
