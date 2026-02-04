package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 2: String Utility Methods
 * This class provides utility methods for String manipulation and their JUnit
 * tests.
 * Methods included: reverse, isPalindrome, toUpperCase.
 */
class StringUtils {
    // Reverses the given string
    public String reverse(String str) {
        if (str == null)
            return null;
        return new StringBuilder(str).reverse().toString();
    }

    // Checks if the given string is a palindrome
    public boolean isPalindrome(String str) {
        if (str == null)
            return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    // Converts the string to uppercase
    public String toUpperCase(String str) {
        if (str == null)
            return null;
        return str.toUpperCase();
    }
}

public class StringUtilsTest {

    // Test for reverse method
    @Test
    public void testReverse() {
        StringUtils utils = new StringUtils();
        assertEquals("cba", utils.reverse("abc"), "Reverse of 'abc' should be 'cba'");
    }

    // Test for isPalindrome method with a palindrome
    @Test
    public void testIsPalindromeTrue() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("madam"), "'madam' should be a palindrome");
    }

    // Test for isPalindrome method with a non-palindrome
    @Test
    public void testIsPalindromeFalse() {
        StringUtils utils = new StringUtils();
        assertFalse(utils.isPalindrome("hello"), "'hello' should not be a palindrome");
    }

    // Test for toUpperCase method
    @Test
    public void testToUpperCase() {
        StringUtils utils = new StringUtils();
        assertEquals("HELLO", utils.toUpperCase("hello"), "'hello' converted to uppercase should be 'HELLO'");
    }
}
