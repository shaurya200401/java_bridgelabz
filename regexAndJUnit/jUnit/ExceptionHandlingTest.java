package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 4: Testing Exception Handling
 * This class demonstrates exception handling by throwing an ArithmeticException
 * when dividing by zero.
 * Includes a JUnit test to verify the exception.
 */
class MathOperation {
    // Divides two numbers and throws exception if descriptor is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class ExceptionHandlingTest {

    // Test to verify ArithmeticException is thrown
    @Test
    public void testDivideByZeroException() {
        MathOperation math = new MathOperation();
        // Assert that the exception is thrown
        assertThrows(ArithmeticException.class, () -> {
            math.divide(10, 0);
        }, "Should throw ArithmeticException when dividing by zero");
    }

    // Test for normal division
    @Test
    public void testNormalDivision() {
        MathOperation math = new MathOperation();
        assertEquals(5, math.divide(10, 2), "10 / 2 should be 5");
    }
}
