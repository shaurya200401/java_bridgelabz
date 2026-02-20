package annotationsReflections.annotation;

/*
 * Exercise 1: Use @Override Correctly
 * Problem Statement:
 * Create a parent class Animal with a method makeSound(). Then, create a Dog class that overrides this method using @Override.
 * Steps:
 * 1. Define a makeSound() method in Animal class.
 * 2. Override it in Dog class with @Override.
 * 3. Instantiate Dog and call makeSound().
 */
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

/*
 * Dog class extending Animal to demonstrate @Override
 */
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

/*
 * Main class to test the @Override annotation
 */
public class OverrideAnnotationTest {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}
