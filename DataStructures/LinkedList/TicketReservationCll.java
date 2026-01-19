package DataStructures.LinkedList;

/**
 * Online Ticket Reservation System using Circular Linked List.
 * Loop through booked tickets.
 */
public class TicketReservationCll {

    static class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        public TicketNode(int id, String customer, String movie, String seat, String time) {
            this.ticketId = id;
            this.customerName = customer;
            this.movieName = movie;
            this.seatNumber = seat;
            this.bookingTime = time;
            this.next = null;
        }
    }

    private TicketNode head;
    private TicketNode tail;

    // Add new ticket reservation at end
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Ticket booked for " + customer + " (ID: " + id + ")");
    }

    // Remove ticket by ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets.");
            return;
        }

        TicketNode current = head;
        TicketNode prev = tail;

        if (current.ticketId == id) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Ticket ID " + id + " cancelled.");
            return;
        }

        do {
            prev = current;
            current = current.next;
            if (current.ticketId == id) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                System.out.println("Ticket ID " + id + " cancelled.");
                return;
            }
        } while (current != head);

        System.out.println("Ticket ID " + id + " not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No booked tickets.");
            return;
        }
        TicketNode temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: "
                    + temp.movieName + ", Seat: " + temp.seatNumber);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for ticket by Customer or Movie
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket: ID " + temp.ticketId + ", Customer: " + temp.customerName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found)
            System.out.println("No tickets match query: " + query);
    }

    // Calculate total number of tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationCll reservation = new TicketReservationCll();
        reservation.addTicket(101, "John Doe", "Avatar 2", "A1", "10:00 AM");
        reservation.addTicket(102, "Jane Smith", "Inception", "B2", "11:00 AM");
        reservation.addTicket(103, "Bob Brown", "Avatar 2", "A2", "10:00 AM");

        reservation.displayTickets();
        reservation.countTickets();

        reservation.searchTicket("Avatar 2");

        reservation.removeTicket(102);
        reservation.displayTickets();
    }
}
