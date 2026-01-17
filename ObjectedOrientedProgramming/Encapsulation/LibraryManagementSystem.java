package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * LibraryManagementSystem Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * LibraryItem is the abstract superclass.
 * Reservable is an interface.
 */
public class LibraryManagementSystem {

    interface Reservable {
        void reserveItem(String userId);

        boolean checkAvailability();
    }

    static abstract class LibraryItem implements Reservable {
        private String itemId;
        private String title;
        private String author;
        private boolean isReserved;

        public LibraryItem(String itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
            this.isReserved = false;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isReserved() {
            return isReserved;
        }

        protected void setReserved(boolean reserved) {
            isReserved = reserved;
        }

        public abstract int getLoanDuration();

        public void getItemDetails() {
            System.out.println("ID: " + itemId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Loan Duration: " + getLoanDuration() + " days");
            System.out.println("Available: " + (!isReserved));
        }

        @Override
        public void reserveItem(String userId) {
            if (!isReserved) {
                isReserved = true;
                System.out.println("Item reserved for User: " + userId);
            } else {
                System.out.println("Item already reserved.");
            }
        }

        @Override
        public boolean checkAvailability() {
            return !isReserved;
        }
    }

    static class Book extends LibraryItem {
        public Book(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 14; // Books loan for 14 days
        }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 7; // Magazines loan for 7 days
        }
    }

    static class DVD extends LibraryItem {
        public DVD(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 3; // DVDs loan for 3 days
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> library = new ArrayList<>();
        library.add(new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.add(new Magazine("M202", "National Geographic", "Various"));
        library.add(new DVD("D303", "Inception", "Christopher Nolan"));

        System.out.println("Library Items:");
        for (LibraryItem item : library) {
            item.getItemDetails();
            if (item.checkAvailability()) {
                item.reserveItem("User123");
            }
            System.out.println("-------------------------");
        }
    }
}
