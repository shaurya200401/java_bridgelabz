package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced Problem 2: Testing Password Strength Validator
 * This class validates passwords based on rules: at least 8 chars, 1 uppercase,
 * 1 digit.
 */
class PasswordValidator {
    // Validates the password
    public boolean isValid(String password) {
        if (password == null)
            return false;
        if (password.length() < 8)
            return false;
        if (!password.matches(".*[A-Z].*"))
            return false; // Check for at least one uppercase
        if (!password.matches(".*\\d.*"))
            return false; // Check for at least one digit
        return true;
    }
}

public class PasswordValidatorTest {

    // Test valid password
    @Test
    public void testValidPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("Password123"), "Password123 should be valid");
    }

    // Test password too short
    @Test
    public void testShortPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("Pass1"), "Pass1 should be invalid (too short)");
    }

    // Test password without uppercase
    @Test
    public void testNoUpperCase() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("password123"), "password123 should be invalid (no uppercase)");
    }

    // Test password without digit
    @Test
    public void testNoDigit() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("PasswordOne"), "PasswordOne should be invalid (no digit)");
    }
}
