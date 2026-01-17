package Inheritance;

/*
 * VehicleTransportSystem Class
 * Demonstrates polymorphism by storing objects of different subclasses in an array of Vehicle type.
 * Hierarchy with Vehicle as superclass and Car, Truck, and Motorcycle as subclasses.
 */

public class VehicleTransportSystem {

    static class Vehicle {
        double maxSpeed;
        String fuelType;

        public Vehicle(double maxSpeed, String fuelType) {
            this.maxSpeed = maxSpeed;
            this.fuelType = fuelType;
        }

        public void displayInfo() {
            System.out.println("Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
        }
    }

    static class Car extends Vehicle {
        int seatCapacity;

        public Car(double maxSpeed, String fuelType, int seatCapacity) {
            super(maxSpeed, fuelType);
            this.seatCapacity = seatCapacity;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Type: Car, Seat Capacity: " + seatCapacity);
        }
    }

    static class Truck extends Vehicle {
        double loadCapacity;

        public Truck(double maxSpeed, String fuelType, double loadCapacity) {
            super(maxSpeed, fuelType);
            this.loadCapacity = loadCapacity;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Type: Truck, Load Capacity: " + loadCapacity + " tons");
        }
    }

    static class Motorcycle extends Vehicle {
        boolean hasSidecar;

        public Motorcycle(double maxSpeed, String fuelType, boolean hasSidecar) {
            super(maxSpeed, fuelType);
            this.hasSidecar = hasSidecar;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Type: Motorcycle, Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 15.5);
        vehicles[2] = new Motorcycle(160, "Petrol", false);

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("-------------------------");
        }
    }
}
