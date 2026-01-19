package DataStructures.LinkedList;

/**
 * Library Management System using Doubly Linked List.
 * Computes total books and supports bidirectional traversal.
 */
public class LibraryManagementDll {

    static class BookNode {
        String title;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        BookNode next;
        BookNode prev;

        public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    private BookNode head;
    private BookNode tail;

    // Add book at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean avail) {
        BookNode newNode = new BookNode(title, author, genre, id, avail);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning: " + title);
    }

    // Add book at end
    public void addAtEnd(String title, String author, String genre, int id, boolean avail) {
        BookNode newNode = new BookNode(title, author, genre, id, avail);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end: " + title);
    }

    // Add book at specific position
    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean avail) {
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(title, author, genre, id, avail);
            return;
        }
        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else if (temp.next == null) {
            addAtEnd(title, author, genre, id, avail);
        } else {
            BookNode newNode = new BookNode(title, author, genre, id, avail);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            System.out.println("Book added at position " + pos);
        }
    }

    // Remove book by ID
    public void removeBookById(int id) {
        if (head == null)
            return;

        BookNode temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
            else
                head = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Book with ID " + id + " removed.");
    }

    // Search by Title or Author
    public void searchBook(String query) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No books found matching: " + query);
    }

    private void printBook(BookNode node) {
        System.out.println("ID: " + node.bookId + ", Title: " + node.title + ", Author: " + node.author
                + ", Available: " + node.isAvailable);
    }

    // Update Availability
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated for ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    // Display Forward
    public void displayForward() {
        System.out.println("Library (Forward):");
        BookNode temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display Backward
    public void displayBackward() {
        System.out.println("Library (Backward):");
        BookNode temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count Total Books
    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books in Library: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementDll lib = new LibraryManagementDll();
        lib.addAtEnd("Harry Potter", "JK Rowling", "Fantasy", 101, true);
        lib.addAtBeginning("The Hobart", "Tolkien", "Fantasy", 100, true);
        lib.addAtPosition(2, "Data Structures", "Unknown", "Edu", 102, false);

        lib.displayForward();
        lib.countBooks();

        lib.searchBook("JK Rowling");
        lib.updateAvailability(102, true);

        lib.removeBookById(100);
        lib.displayBackward();
    }
}
