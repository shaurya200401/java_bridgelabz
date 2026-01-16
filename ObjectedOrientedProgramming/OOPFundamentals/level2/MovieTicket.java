package OOPFundamentals.level2;

/*
 * Program: Movie Ticket Booking
 * Purpose: Defines a MovieTicket class to book tickets and display details.
 */
public class MovieTicket {
    // Ticket info attributes
    String movieName;
    String seatNumber;
    double price;

    // Constructor to set initial data
    public MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to update/book ticket
    public void bookTicket(String name, String seat, double cost) {
        this.movieName = name;
        this.seatNumber = seat;
        this.price = cost;
        System.out.println("Ticket booked successfully!");
    }

    // Method to show print details
    public void displayTicket() {
        System.out.println("Movie Ticket Details:");
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Initialize dummy ticket
        MovieTicket ticket = new MovieTicket("Inception", "A1", 12.50);
        // Display details
        ticket.displayTicket();
    }
}
