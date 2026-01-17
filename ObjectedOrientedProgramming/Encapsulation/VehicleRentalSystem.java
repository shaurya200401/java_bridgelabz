package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * VehicleRentalSystem Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * Vehicle is the abstract superclass.
 * Insurable is an interface.
 */
public class VehicleRentalSystem {

    interface Insurable {
        double calculateInsurance();

        String getInsuranceDetails();
    }

    static abstract class Vehicle implements Insurable {
        private String vehicleNumber;
        private String type;
        private double rentalRate;

        // Encapsulated field for insurance policy number
        private String insurancePolicyNumber;

        public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
            this.vehicleNumber = vehicleNumber;
            this.type = type;
            this.rentalRate = rentalRate;
            this.insurancePolicyNumber = insurancePolicyNumber;
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getRentalRate() {
            return rentalRate;
        }

        public void setRentalRate(double rentalRate) {
            this.rentalRate = rentalRate;
        }

        // Restrict access to sensitive details
        protected String getInsurancePolicyNumber() {
            return insurancePolicyNumber;
        }

        public abstract double calculateRentalCost(int days);

        public void displayVehicleDetails() {
            System.out.println("Vehicle No: " + vehicleNumber + ", Type: " + type);
            System.out.println("Rental Rate: $" + rentalRate + "/day");
            System.out.println("Insurance: $" + calculateInsurance() + " (" + getInsuranceDetails() + ")");
        }
    }

    static class Car extends Vehicle {
        public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
            super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
        }

        @Override
        public double calculateRentalCost(int days) {
            return getRentalRate() * days;
        }

        @Override
        public double calculateInsurance() {
            return 500; // Flat insurance rate for car
        }

        @Override
        public String getInsuranceDetails() {
            return "Compact Car Insurance";
        }
    }

    static class Bike extends Vehicle {
        public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
            super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
        }

        @Override
        public double calculateRentalCost(int days) {
            return getRentalRate() * days * 0.9; // 10% discount for bikes on rental
        }

        @Override
        public double calculateInsurance() {
            return 200; // Flat insurance for bike
        }

        @Override
        public String getInsuranceDetails() {
            return "Two-Wheeler Insurance";
        }
    }

    static class Truck extends Vehicle {
        public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
            super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
        }

        @Override
        public double calculateRentalCost(int days) {
            return getRentalRate() * days + 100; // Additional charge for trucks
        }

        @Override
        public double calculateInsurance() {
            return 1000;
        }

        @Override
        public String getInsuranceDetails() {
            return "Commercial Vehicle Insurance";
        }
    }

    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("MH12AB1234", 100, "POL-123"));
        fleet.add(new Bike("MH12XY5678", 40, "POL-456"));
        fleet.add(new Truck("MH12ZZ9999", 300, "POL-789"));

        int rentalDays = 5;
        System.out.println("Rental Details for " + rentalDays + " days:");
        for (Vehicle v : fleet) {
            v.displayVehicleDetails();
            System.out.println("Total Cost: $" + v.calculateRentalCost(rentalDays));
            System.out.println("-------------------------");
        }
    }
}
