package designPatterns;

/*
 * abstract factory pattern: vehicle factory
 * provides an interface for creating families of related or dependent objects
 * without specifying their concrete classes
 */

// interface for car
interface Car {
    void drive();
}

// interface for bike
interface Bike {
    void ride();
}

// concrete class sedan implementing car
class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a Sedan Car");
    }
}

// concrete class suv implementing car
class SUV implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an SUV Car");
    }
}

// concrete class sportsbike implementing bike
class SportsBike implements Bike {
    @Override
    public void ride() {
        System.out.println("Riding a Sports Bike");
    }
}

// concrete class normalbike implementing bike
class NormalBike implements Bike {
    @Override
    public void ride() {
        System.out.println("Riding a Normal Bike");
    }
}

/*
 * abstract factory interface
 */
interface VehicleBaseFactory {
    Car createCar(String type);

    Bike createBike(String type);
}

// concrete factory for cars
class CarFactory implements VehicleBaseFactory {
    @Override
    public Car createCar(String type) {
        if ("Sedan".equalsIgnoreCase(type)) {
            return new Sedan();
        } else if ("SUV".equalsIgnoreCase(type)) {
            return new SUV();
        }
        return null;
    }

    @Override
    public Bike createBike(String type) {
        return null; // car factory doesn't create bikes
    }
}

// concrete factory for bikes
class BikeFactory implements VehicleBaseFactory {
    @Override
    public Car createCar(String type) {
        return null; // bike factory doesn't create cars
    }

    @Override
    public Bike createBike(String type) {
        if ("Sports".equalsIgnoreCase(type)) {
            return new SportsBike();
        } else if ("Normal".equalsIgnoreCase(type)) {
            return new NormalBike();
        }
        return null;
    }
}

/*
 * main class to demonstrate abstract factory
 */
public class VehicleFactory {

    // main method to test abstract factory pattern
    public static void main(String[] args) {
        // creating a car factory
        VehicleBaseFactory carFactory = new CarFactory();
        Car myCar = carFactory.createCar("Sedan");
        if (myCar != null)
            myCar.drive();

        Car mySuv = carFactory.createCar("SUV");
        if (mySuv != null)
            mySuv.drive();

        // creating a bike factory
        VehicleBaseFactory bikeFactory = new BikeFactory();
        Bike myBike = bikeFactory.createBike("Sports");
        if (myBike != null)
            myBike.ride();

        Bike myNormalBike = bikeFactory.createBike("Normal");
        if (myNormalBike != null)
            myNormalBike.ride();
    }
}
