package exceptions;

/**
 * Program 17: Exception Handling with Resource Cleanup
 * 
 * Problem Statement:
 * Minimize a connection that requires cleanup.
 * Implement a class that demonstrates handling exceptions while ensuring proper
 * resource cleanup.
 */

// Simulating a Resource that needs explicit cleanup (like a Database
// Connection)
class DatabaseConnection implements AutoCloseable {
    public DatabaseConnection() {
        System.out.println("Database Connection Established.");
    }

    public void executeQuery(String query) {
        System.out.println("Executing Query: " + query);
        if ("BAD QUERY".equals(query)) {
            throw new RuntimeException("Syntax Error in SQL Query.");
        }
    }

    // Implementing close() from AutoCloseable
    @Override
    public void close() {
        System.out.println("Database Connection Closed.");
    }
}

public class ResourceCleanup {
    public static void main(String[] args) {
        System.out.println("Starting Resource Management Demo...");

        // Approach 1: Using try-with-resources (Best Practice for AutoCloseable)
        System.out.println("\n--- Approach 1: Try-With-Resources ---");
        try (DatabaseConnection db = new DatabaseConnection()) {
            db.executeQuery("SELECT * FROM users");
            db.executeQuery("BAD QUERY"); // This will throw exception
        } catch (Exception e) {
            System.out.println("Exception handled: " + e.getMessage());
        }
        // Connection closed automatically here

        // Approach 2: Using try-catch-finally (Legacy Approach)
        System.out.println("\n--- Approach 2: Try-Catch-Finally ---");
        DatabaseConnection manualDb = null;
        try {
            manualDb = new DatabaseConnection();
            manualDb.executeQuery("SELECT * FROM orders");
        } catch (Exception e) {
            System.out.println("Exception handled: " + e.getMessage());
        } finally {
            if (manualDb != null) {
                System.out.println("Executing manual cleanup in finally block.");
                manualDb.close();
            }
        }
    }
}
