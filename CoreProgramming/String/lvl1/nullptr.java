package String.lvl1;
public class nullptr {
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // This will crash
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Cannot access method on null.");
        }
    }

    public static void main(String[] args) {
        // generateException(); // Uncomment to see abrupt stop
        handleException();
    }
}