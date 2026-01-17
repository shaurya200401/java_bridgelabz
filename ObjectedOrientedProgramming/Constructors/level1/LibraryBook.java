package Constructors.level1;
/*
 * LibraryBook Class
 * Represents a book in a library system.
 * Includes availability status and a method to borrow the book.
 */
public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    // Constructor to initialize book details
    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (available) {
            available = false; // Set availability to false
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is currently unavailable.");
        }
    }

    public void displayStatus() {
        System.out.println("Title: " + title + ", Available: " + (available ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        LibraryBook lb = new LibraryBook("Java Programming", "James Gosling", 25.0, true);
        lb.displayStatus();
        lb.borrowBook(); // Borrowing
        lb.displayStatus();
        lb.borrowBook(); // Trying to borrow again
    }
}
