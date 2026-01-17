package Constructors.level1;
/*
 * Book Class
 * This class demonstrates the use of default and parameterized constructors.
 * It has attributes for title, author, and price.
 */
public class Book {
    String title;
    String author;
    double price;

    // Default Constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        System.out.println("Default Constructor called");
    }

    // Parameterized Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Parameterized Constructor called");
    }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }

    public static void main(String[] args) {
        // Using default constructor
        Book book1 = new Book();
        book1.displayDetails();

        // Using parameterized constructor
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        book2.displayDetails();
    }
}
