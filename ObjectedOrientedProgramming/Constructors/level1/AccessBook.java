package Constructors.level1;
/*
 * AccessBook Class
 * Renamed from Book to avoid conflict with the previous Book class.
 * Demonstrates access modifiers with ISBN, title, and author.
 */
public class AccessBook {
    public String isbn;
    protected String title;
    private String author;

    public AccessBook(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        AccessBook b = new AccessBook("123-456", "Java Guide", "James");
        System.out.println("ISBN: " + b.isbn);
        System.out.println("Title: " + b.title);
        // System.out.println("Author: " + b.author); // Private
        System.out.println("Author: " + b.getAuthor());

        EBook ebook = new EBook("789-012", "Advanced Java", "Gosling");
        ebook.displayBookInfo();
    }
}

class EBook extends AccessBook {
    public EBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    public void displayBookInfo() {
        System.out.println("EBook Info:");
        System.out.println("ISBN: " + isbn); // Public
        System.out.println("Title: " + title); // Protected
        // System.out.println("Author: " + author); // Private: Not accessible
        System.out.println("Author: " + getAuthor());
    }
}
