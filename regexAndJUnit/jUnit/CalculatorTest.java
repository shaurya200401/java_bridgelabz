package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 1: Basic JUnit Test - Calculator Class
 * This class provides basic arithmetic operations and their corresponding JUnit
 * tests.
 * Methods included: add, subtract, multiply, divide.
 */
class Calculator {
    // Adds two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts the second integer from the first
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two integers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divides the first integer by the second, throws ArithmeticException if b is 0
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class CalculatorTest {

    // Test for addition method
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }

    // Test for subtraction method
    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(3, 2), "3 - 2 should equal 1");
    }

    // Test for multiplication method
    @Test
    public void testMultiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3), "2 * 3 should equal 6");
    }

    // Test for division method
    @Test
    public void testDivide() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(6, 3), "6 / 3 should equal 2");
    }

    // Bonus: Test for division by zero exception
    @Test
    public void testDivideByZero() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0),
                "Division by zero should throw ArithmeticException");
    }
}
