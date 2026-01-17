package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * RideHailingApplication Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * Vehicle is the abstract superclass.
 * GPS is an interface.
 */
public class RideHailingApplication {

    interface GPS {
        String getCurrentLocation();

        void updateLocation(String newLocation);
    }

    static abstract class Vehicle implements GPS {
        private String vehicleId;
        private String driverName;
        private double ratePerKm;
        private String currentLocation;

        public Vehicle(String vehicleId, String driverName, double ratePerKm) {
            this.vehicleId = vehicleId;
            this.driverName = driverName;
            this.ratePerKm = ratePerKm;
            this.currentLocation = "Garage"; // Default
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public double getRatePerKm() {
            return ratePerKm;
        }

        public void setRatePerKm(double ratePerKm) {
            this.ratePerKm = ratePerKm;
        }

        @Override
        public String getCurrentLocation() {
            return currentLocation;
        }

        @Override
        public void updateLocation(String newLocation) {
            this.currentLocation = newLocation;
            System.out.println("Location updated to: " + newLocation);
        }

        public abstract double calculateFare(double distance);

        public void getVehicleDetails() {
            System.out.println("Vehicle ID: " + vehicleId);
            System.out.println("Driver: " + driverName);
            System.out.println("Rate/Km: $" + ratePerKm);
            System.out.println("Location: " + currentLocation);
        }
    }

    static class Car extends Vehicle {
        public Car(String vehicleId, String driverName, double ratePerKm) {
            super(vehicleId, driverName, ratePerKm);
        }

        @Override
        public double calculateFare(double distance) {
            return getRatePerKm() * distance;
        }
    }

    static class Bike extends Vehicle {
        public Bike(String vehicleId, String driverName, double ratePerKm) {
            super(vehicleId, driverName, ratePerKm);
        }

        @Override
        public double calculateFare(double distance) {
            return getRatePerKm() * distance * 0.8; // Cheaper rates
        }
    }

    static class Auto extends Vehicle {
        public Auto(String vehicleId, String driverName, double ratePerKm) {
            super(vehicleId, driverName, ratePerKm);
        }

        @Override
        public double calculateFare(double distance) {
            // Auto rates
            return getRatePerKm() * distance;
        }
    }

    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        rides.add(new Car("KA01AB1234", "Alex", 15));
        rides.add(new Bike("KA01XY5678", "Sam", 8));
        rides.add(new Auto("KA01ZZ9999", "Tom", 10));

        System.out.println("Ride Hailing System:");
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            v.updateLocation("City Center");
            System.out.println("Fare for 10km: $" + v.calculateFare(10));
            System.out.println("-------------------------");
        }
    }
}
