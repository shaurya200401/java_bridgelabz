package Constructors.level1;
/*
 * Person Class
 * This class demonstrates the use of a copy constructor.
 * It copies attributes (name, age) from another Person object.
 */
public class Person {
    String name;
    int age;

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        System.out.println("Copy Constructor called");
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        System.out.println("Original Person:");
        p1.displayDetails();

        // Creating p2 by copying p1
        Person p2 = new Person(p1);
        System.out.println("Copied Person:");
        p2.displayDetails();
    }
}
