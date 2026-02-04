package regexAndJUnit.jUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 5: Testing @BeforeEach and @AfterEach Annotations
 * This class simulates a database connection.
 * Uses @BeforeEach to connect and @AfterEach to disconnect.
 */
class DatabaseConnection {
    private boolean isConnected = false;

    // Establishes a connection
    public void connect() {
        isConnected = true;
        System.out.println("Database Connected");
    }

    // Closes the connection
    public void disconnect() {
        isConnected = false;
        System.out.println("Database Disconnected");
    }

    // Returns the connection status
    public boolean isConnected() {
        return isConnected;
    }
}

public class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;

    // Runs before each test method
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    // Runs after each test method
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }

    // Test to verify connection
    @Test
    public void testConnection() {
        assertTrue(dbConnection.isConnected(), "Database should be connected");
        System.out.println("Executing testConnection...");
    }

    // Another test to demonstrate setup/teardown runs again
    @Test
    public void testConnectionAgain() {
        assertTrue(dbConnection.isConnected(), "Database should be connected in second test");
        System.out.println("Executing testConnectionAgain...");
    }
}
