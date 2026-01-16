package String.lvl1;

public class illegalarg {
    public static void generate(String s) {
        System.out.println(s.substring(5, 2)); // Start > End
    }

    public static void handle(String s) {
        try {
            System.out.println(s.substring(5, 2));
        } catch (IllegalArgumentException | StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: Invalid arguments for substring.");
        }
    }

    public static void main(String[] args) {
        String text = "JavaProgramming";
        handle(text);
    }
}