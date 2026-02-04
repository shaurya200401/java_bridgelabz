package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Advanced Problem 3: Testing Temperature Converter
 * This class converts temperatures between Celsius and Fahrenheit.
 */
class TemperatureConverter {
    // Converts Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Converts Fahrenheit to Celsius
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class TemperatureConverterTest {

    // Test C to F
    @Test
    public void testCelsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001, "0C should be 32F");
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001, "100C should be 212F");
    }

    // Test F to C
    @Test
    public void testFahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001, "32F should be 0C");
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001, "212F should be 100C");
    }
}
