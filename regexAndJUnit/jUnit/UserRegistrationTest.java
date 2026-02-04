package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced Problem 5: Testing User Registration
 * This class registers a user and validates inputs.
 * Throws IllegalArgumentException for invalid inputs.
 */
class UserRegistration {
    // Register user: validation logic
    public void registerUser(String username, String email, String password) {
        if (username == null || username.length() < 3) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Invalid password");
        }
        System.out.println("User registered successfully");
    }
}

public class UserRegistrationTest {

    // Test valid registration
    @Test
    public void testValidRegistration() {
        UserRegistration reg = new UserRegistration();
        assertDoesNotThrow(() -> reg.registerUser("user1", "user@example.com", "password123"),
                "Should register successfully");
    }

    // Test invalid username
    @Test
    public void testInvalidUsername() {
        UserRegistration reg = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> reg.registerUser("u", "user@example.com", "pass123"),
                "Should throw for short username");
    }

    // Test invalid email
    @Test
    public void testInvalidEmail() {
        UserRegistration reg = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> reg.registerUser("user1", "userexample.com", "pass123"),
                "Should throw for invalid email");
    }

    // Test invalid password
    @Test
    public void testInvalidPassword() {
        UserRegistration reg = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> reg.registerUser("user1", "user@example.com", "pass"),
                "Should throw for short password");
    }
}
