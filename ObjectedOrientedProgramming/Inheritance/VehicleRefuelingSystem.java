package ObjectedOrientedProgramming.Inheritance;

/*
 * VehicleRefuelingSystem Class
 * Demonstrates hybrid inheritance with interfaces.
 * Vehicle is the superclass; ElectricVehicle and PetrolVehicle are subclasses.
 * PetrolVehicle implements the Refuelable interface.
 */

public class VehicleRefuelingSystem {

    interface Refuelable {
        void refuel();
    }

    static class Vehicle {
        String model;
        double maxSpeed;

        public Vehicle(String model, double maxSpeed) {
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        public void displaySpecs() {
            System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
        }
    }

    static class ElectricVehicle extends Vehicle {
        double batteryCapacity;

        public ElectricVehicle(String model, double maxSpeed, double batteryCapacity) {
            super(model, maxSpeed);
            this.batteryCapacity = batteryCapacity;
        }

        public void charge() {
            System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh.");
        }
    }

    static class PetrolVehicle extends Vehicle implements Refuelable {
        double fuelTankCapacity;

        public PetrolVehicle(String model, double maxSpeed, double fuelTankCapacity) {
            super(model, maxSpeed);
            this.fuelTankCapacity = fuelTankCapacity;
        }

        @Override
        public void refuel() {
            System.out.println(model + " is refueling. Tank Capacity: " + fuelTankCapacity + " liters.");
        }
    }

    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 260, 75);
        PetrolVehicle ford = new PetrolVehicle("Ford Mustang", 250, 60);

        tesla.displaySpecs();
        tesla.charge();

        System.out.println();

        ford.displaySpecs();
        ford.refuel();
    }
}
