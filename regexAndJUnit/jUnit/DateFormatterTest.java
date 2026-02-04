package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced Problem 4: Testing Date Formatter
 * This class formats dates from yyyy-MM-dd to dd-MM-yyyy.
 */
class DateFormatter {
    // Formats date string
    public String formatDate(String inputDate) {
        // Regex to check format yyyy-MM-dd
        if (!inputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid date format");
        }
        String[] parts = inputDate.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }
}

public class DateFormatterTest {

    // Test valid date format
    @Test
    public void testValidDate() {
        DateFormatter formatter = new DateFormatter();
        assertEquals("04-02-2026", formatter.formatDate("2026-02-04"), "Should reformat to dd-MM-yyyy");
    }

    // Test invalid date format
    @Test
    public void testInvalidDate() {
        DateFormatter formatter = new DateFormatter();
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("04/02/2026"),
                "Should throw exception for invalid format");
    }
}
