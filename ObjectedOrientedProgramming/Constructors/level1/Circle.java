package Constructors.level1;
/*
 * Circle Class
 * This class demonstrates constructor chaining using 'this()'.
 * It has a radius attribute.
 */
public class Circle {
    double radius;

    // Default Constructor calling parameterized constructor
    public Circle() {
        this(1.0); // Default radius 1.0
        System.out.println("Default Constructor called (Chained)");
    }

    // Parameterized Constructor
    public Circle(double radius) {
        this.radius = radius;
        System.out.println("Parameterized Constructor called");
    }

    public void displayRadius() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        // Using default constructor which chains to parameterized
        Circle c1 = new Circle();
        c1.displayRadius();

        // Using parameterized constructor directly
        Circle c2 = new Circle(5.5);
        c2.displayRadius();
    }
}
