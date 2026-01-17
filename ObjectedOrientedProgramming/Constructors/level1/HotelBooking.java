package Constructors.level1;
/*
 * HotelBooking Class
 * This class represents a hotel booking system.
 * It demonstrates default, parameterized, and copy constructors.
 */
public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default Constructor
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void displayBooking() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking(); // Default
        HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3); // Parameterized
        HotelBooking booking3 = new HotelBooking(booking2); // Copy

        booking1.displayBooking();
        booking2.displayBooking();
        booking3.displayBooking();
    }
}
