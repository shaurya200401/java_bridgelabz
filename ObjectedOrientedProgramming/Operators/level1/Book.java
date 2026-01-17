package Operators.level1;

/*
 * Book Class
 * Manages library books with static library name and final ISBN.
 * Demonstrates constructor initialization and instanceof checks.
 */
public class Book {
    static String libraryName = "City Central Library"; // Shared library name
    final String isbn; // Unique identifier, cannot change
    String title;
    String author;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title; // Using this
        this.author = author;
        this.isbn = isbn; // Initializing final variable
    }

    // Static method
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Book.displayLibraryName();

        Book b1 = new Book("The Alchemist", "Paulo Coelho", "978-0061122415");

        // Instanceof check
        if (b1 instanceof Book) {
            b1.displayBookDetails();
        }
    }
}
