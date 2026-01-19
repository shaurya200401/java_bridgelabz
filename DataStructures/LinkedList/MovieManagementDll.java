package DataStructures.LinkedList;

/**
 * Movie Management System using Doubly Linked List.
 * Allows forward and reverse traversal.
 */
public class MovieManagementDll {

    static class MovieNode {
        String title;
        String director;
        int year;
        double rating;
        MovieNode next;
        MovieNode prev;

        public MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    private MovieNode head;
    private MovieNode tail;

    // Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at beginning: " + title);
    }

    // Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at end: " + title);
    }

    // Add movie at position
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else if (temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            MovieNode newNode = new MovieNode(title, director, year, rating);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            System.out.println("Movie added at position " + pos + ": " + title);
        }
    }

    // Remove by Title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
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
        System.out.println("Movie removed: " + title);
    }

    // Search by Director or Rating
    public void search(String keywordOrRating) {
        MovieNode temp = head;
        boolean found = false;
        try {
            double rating = Double.parseDouble(keywordOrRating);
            while (temp != null) {
                if (temp.rating == rating) {
                    printMovie(temp);
                    found = true;
                }
                temp = temp.next;
            }
        } catch (NumberFormatException e) {
            while (temp != null) {
                if (temp.director.equalsIgnoreCase(keywordOrRating)) {
                    printMovie(temp);
                    found = true;
                }
                temp = temp.next;
            }
        }
        if (!found)
            System.out.println("No movies found for search.");
    }

    private void printMovie(MovieNode node) {
        System.out.println("Title: " + node.title + ", Dir: " + node.director + ", Year: " + node.year + ", Rating: "
                + node.rating);
    }

    // Update Rating
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display Forward
    public void displayForward() {
        System.out.println("Movies (Forward):");
        MovieNode temp = head;
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // Display Backward
    public void displayBackward() {
        System.out.println("Movies (Backward):");
        MovieNode temp = tail;
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementDll mm = new MovieManagementDll();
        mm.addAtEnd("Inception", "Nolan", 2010, 8.8);
        mm.addAtBeginning("The Matrix", "Wachowskis", 1999, 8.7);
        mm.addAtPosition(2, "Interstellar", "Nolan", 2014, 8.6);

        mm.displayForward();
        mm.displayBackward();

        mm.search("Nolan");
        mm.updateRating("Inception", 9.0);

        mm.removeByTitle("Interstellar");
        mm.displayForward();
    }
}
