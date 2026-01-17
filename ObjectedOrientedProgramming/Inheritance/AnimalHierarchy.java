package Inheritance;

/*
 * AnimalHierarchy Class
 * Demonstrates basic inheritance, method overriding, and polymorphism.
 * Creates a hierarchy where Animal is the superclass, and Dog, Cat, and Bird are subclasses.
 */

public class AnimalHierarchy {

    static class Animal {
        String name;
        int age;

        // Constructor
        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method to make sound
        public void makeSound() {
            System.out.println("Animal makes a sound");
        }

        // Display info
        public void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    static class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age);
        }

        @Override
        public void makeSound() {
            System.out.println("Dog barks: Woof Woof");
        }
    }

    static class Cat extends Animal {
        public Cat(String name, int age) {
            super(name, age);
        }

        @Override
        public void makeSound() {
            System.out.println("Cat meows: Meow Meow");
        }
    }

    static class Bird extends Animal {
        public Bird(String name, int age) {
            super(name, age);
        }

        @Override
        public void makeSound() {
            System.out.println("Bird chirps: Tweet Tweet");
        }
    }

    public static void main(String[] args) {
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        dog.displayInfo();
        dog.makeSound();

        cat.displayInfo();
        cat.makeSound();

        bird.displayInfo();
        bird.makeSound();
    }
}
