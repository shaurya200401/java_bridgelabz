package OOPFundamentals.level1;

/*
 * Program: Handle Book Details
 * Purpose: Defines a Book class with title, author, and price, and a method to display details.
 */
public class Book {
    // Attributes for book info
    String title;
    String author;
    double price;

    // Constructor to initialize Book
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to show book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create Book instance
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        // Display info
        book1.displayDetails();
    }
}
