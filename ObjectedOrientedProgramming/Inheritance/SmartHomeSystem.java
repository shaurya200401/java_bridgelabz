package ObjectedOrientedProgramming.Inheritance;

/*
 * SmartHomeSystem Class
 * Demonstrates single inheritance by adding specific attributes to a subclass.
 * Hierarchy with Device as superclass and Thermostat as subclass.
 */

public class SmartHomeSystem {

    static class Device {
        String deviceId;
        String status;

        public Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        public void displayStatus() {
            System.out.println("Device ID: " + deviceId + ", Status: " + status);
        }
    }

    static class Thermostat extends Device {
        double temperatureSetting;

        public Thermostat(String deviceId, String status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        @Override
        public void displayStatus() {
            super.displayStatus();
            System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        }
    }

    public static void main(String[] args) {
        Thermostat livingRoomThermo = new Thermostat("TH101", "Active", 22.5);
        livingRoomThermo.displayStatus();
    }
}
