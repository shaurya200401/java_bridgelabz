package Inheritance;

/*
 * RestaurantManagement Class
 * Demonstrates hybrid inheritance using interfaces.
 * Person is the superclass; Chef and Waiter are subclasses implementing the Worker interface.
 */

public class RestaurantManagement {

    interface Worker {
        void performDuties();
    }

    static class Person {
        String name;
        int id;

        public Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public void displayProfile() {
            System.out.println("ID: " + id + ", Name: " + name);
        }
    }

    static class Chef extends Person implements Worker {
        String specialty;

        public Chef(String name, int id, String specialty) {
            super(name, id);
            this.specialty = specialty;
        }

        @Override
        public void performDuties() {
            System.out.println(name + " is cooking " + specialty + " dishes.");
        }
    }

    static class Waiter extends Person implements Worker {
        int tablesAssigned;

        public Waiter(String name, int id, int tablesAssigned) {
            super(name, id);
            this.tablesAssigned = tablesAssigned;
        }

        @Override
        public void performDuties() {
            System.out.println(name + " is serving " + tablesAssigned + " tables.");
        }
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 501, "Italian");
        Waiter waiter = new Waiter("Emily", 502, 5);

        chef.displayProfile();
        chef.performDuties();

        System.out.println();

        waiter.displayProfile();
        waiter.performDuties();
    }
}
