package designPatterns;

/*
 * singleton pattern: logger class
 * this class ensures only one instance is created
 * contains a private constructor and a static instance
 */
public class Logger {

    // private static instance of the class
    private static Logger instance;

    // private constructor to prevent instantiation
    private Logger() {
        // initialization code
    }

    // public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    // main method to test singleton pattern
    public static void main(String[] args) {
        // getting instances of logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // logging messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // checking if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances.");
        }
    }
}
