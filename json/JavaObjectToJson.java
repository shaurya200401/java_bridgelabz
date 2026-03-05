package json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Converts a Java object (Car) into JSON format using Jackson ObjectMapper.
 */
public class JavaObjectToJson {
    
    // Define Car class
    static class Car {
        public String brand;
        public String model;
        public int year;
        
        // Constructor
        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        // Create Car object
        Car car = new Car("Tesla", "Model S", 2023);
        
        // Instantiate ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Convert to JSON string
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
            
            // Print the result
            System.out.println("JSON Format:");
            System.out.println(jsonOutput);
        } catch (Exception e) {
            // Handle parsing exceptions
            e.printStackTrace();
        }
    }
}
