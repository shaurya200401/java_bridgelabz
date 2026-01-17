package ObjectedOrientedProgramming.Inheritance;

/*
 * LibraryManagement Class
 * Demonstrates single inheritance.
 * Models a Book system where Book is the superclass and Author is a subclass.
 */

public class LibraryManagement {

    static class Book {
        String title;
        int publicationYear;

        public Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        public void displayInfo() {
            System.out.println("Title: " + title);
            System.out.println("Publication Year: " + publicationYear);
        }
    }

    static class Author extends Book {
        String authorName;
        String bio;

        public Author(String title, int publicationYear, String authorName, String bio) {
            super(title, publicationYear);
            this.authorName = authorName;
            this.bio = bio;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Author: " + authorName);
            System.out.println("Bio: " + bio);
        }
    }

    public static void main(String[] args) {
        Author authorBook = new Author("Effective Java", 2008, "Joshua Bloch", "Java Platform Architect");
        authorBook.displayInfo();
    }
}
